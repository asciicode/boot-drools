package com.ascii.framework.base.kie.service;

import com.ascii.framework.base.rule.dto.RuleExecutionRequestDTO;

public interface RuleExecutionService {

    String execute(RuleExecutionRequestDTO ruleExecutionRequestDTO);
}
