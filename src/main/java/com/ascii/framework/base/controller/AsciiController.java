package com.ascii.framework.base.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ascii.condition.sample.dto.ConditionDTO;
import com.ascii.framework.base.dto.BaseDTO;
import com.ascii.framework.base.kie.service.RuleExecutionService;
import com.ascii.framework.base.rule.dto.RuleExecutionRequestDTO;

@RestController
public class AsciiController {

    @Autowired
    private RuleExecutionService ruleExecutionService;

    @RequestMapping(value = "/ascii-drools", method = RequestMethod.GET, produces = "application/json")
    public void getAsciiDrools() {

        RuleExecutionRequestDTO ruleExecutionRequestDTO = new RuleExecutionRequestDTO();
        List<BaseDTO> facts = new ArrayList<>();
        ConditionDTO conditionDTO = new ConditionDTO();
        conditionDTO.setComplianceCheckPreTradeValidationApplicable(true);
        facts.add(conditionDTO);
        ruleExecutionRequestDTO.setFacts(facts);
        ruleExecutionService.execute(ruleExecutionRequestDTO);
    }
}
