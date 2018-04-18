package com.ascii.framework.base.kie.listener;

import org.drools.core.definitions.rule.impl.RuleImpl;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.springframework.stereotype.Service;

import com.ascii.framework.base.rule.dto.RuleExecutionResultSetDTO;

@Service
public class KieContainerRuleExecutionAgendaEventListener extends DefaultAgendaEventListener {
    @Override
    public void afterMatchFired(AfterMatchFiredEvent event) {
        RuleImpl rule = (RuleImpl) event.getMatch().getRule();
        System.out.println(String.format("Fired match for agenda group [{}], rule [{}], rule item [{}]", rule.getAgendaGroup(),
                rule.getActivationGroup(), rule.getName()));
        RuleExecutionResultSetDTO ruleExecutionResultSetDTO = (RuleExecutionResultSetDTO) event.getKieRuntime()
                .getGlobal("ruleExecutionResultSet");
        System.out.println("in listener " + ruleExecutionResultSetDTO);
        ruleExecutionResultSetDTO.postProcess(rule.getAgendaGroup(), rule.getActivationGroup());
    }

    @Override
    public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
        System.out.println(String.format("Popped agenda group [{}]", event.getAgendaGroup().getName()));
    }

    @Override
    public void agendaGroupPushed(AgendaGroupPushedEvent event) {
        System.out.println(String.format("Pushed agenda group [{}]", event.getAgendaGroup().getName()));
    }
}
