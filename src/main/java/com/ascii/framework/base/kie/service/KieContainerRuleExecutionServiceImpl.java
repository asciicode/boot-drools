package com.ascii.framework.base.kie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ascii.framework.base.dto.BaseDTO;
import com.ascii.framework.base.kie.listener.KieContainerRuleExecutionAgendaEventListener;
import com.ascii.framework.base.rule.dto.RuleExecutionRequestDTO;
import com.ascii.framework.base.rule.dto.RuleExecutionResultSetDTO;

@Service
public class KieContainerRuleExecutionServiceImpl implements RuleExecutionService {

    @Autowired
    private KieContainerService kieContainerService;

    @Autowired
    private KieContainerRuleExecutionAgendaEventListener kieContainerRuleExecutionAgendaEventListener;

    @Override
    public String execute(final RuleExecutionRequestDTO ruleExecutionRequestDTO) {
        kieContainerService.refresh(false);

        final List<String> agendaGroupNames = new ArrayList<>();
        agendaGroupNames.add("PRODUCT-DUE-DILIGENCE");
        final RuleExecutionResultSetDTO ruleExecutionResultSetDTO = new RuleExecutionResultSetDTO();
        ruleExecutionResultSetDTO
                .setBusinessDomainPartyNumber(ruleExecutionRequestDTO
                        .getBusinessDomainPartyNumber());
        // ruleExecutionResultSetDTO.setRulePackageNumber(kieRulePackageDTO
        // .getRulePackageNumber());
        ruleExecutionResultSetDTO
                .setRequesterProcessTypeCode(ruleExecutionRequestDTO
                        .getRequesterProcessTypeCode());
        ruleExecutionResultSetDTO
                .setRequesterProcessReferenceNumber(ruleExecutionRequestDTO
                        .getRequesterProcessReferenceNumber());

        kieContainerService.executeWithNewKieSession(
                "partyNumber_1",
                new KieSessionCallback() {

                    @Override
                    public void doInKieSession(KieSession kieSession) {
                        System.out.println("global keys " + kieSession.getGlobals().getGlobalKeys());
                        kieSession.setGlobal("ruleExecutionResultSet", ruleExecutionResultSetDTO);
                        kieSession.addEventListener(kieContainerRuleExecutionAgendaEventListener);
                        for (BaseDTO fact : ruleExecutionRequestDTO.getFacts()) {
                            kieSession.insert(fact);
                        }
                        // iterator at the end of the list
                        ListIterator<String> agendaGroupNameIterator = agendaGroupNames.listIterator(agendaGroupNames.size());
                        // KIE agenda groups are used in LIFO manner, thus
                        // invoking setFocus for the last agenda group first
                        while (agendaGroupNameIterator.hasPrevious()) {
                            kieSession.getAgenda().getAgendaGroup(agendaGroupNameIterator.previous()).setFocus();
                        }
                        kieSession.fireAllRules();
                    }
                });
        // ruleExecutionResultSetService.save(ruleExecutionResultSetDTO);
        System.out.println("ruleExecutionResultSetDTO " + ruleExecutionResultSetDTO);
        return ruleExecutionResultSetDTO.getCheckProcessNumber();
    }


}
