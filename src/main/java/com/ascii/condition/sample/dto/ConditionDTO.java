package com.ascii.condition.sample.dto;

import com.ascii.framework.base.dto.BaseDTO;

public class ConditionDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    private Boolean complianceCheckPreTradeValidationApplicable = Boolean.TRUE;

    public Boolean getComplianceCheckPreTradeValidationApplicable() {
        return complianceCheckPreTradeValidationApplicable;
    }

    public void setComplianceCheckPreTradeValidationApplicable(Boolean complianceCheckPreTradeValidationApplicable) {
        this.complianceCheckPreTradeValidationApplicable = complianceCheckPreTradeValidationApplicable;
    }
}
