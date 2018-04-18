package com.ascii.framework.base.rule.dto;

import java.io.Serializable;
import java.util.List;

import com.ascii.framework.base.dto.BaseDTO;

public class RuleExecutionRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String businessDomainPartyNumber;

    private String rulePackageName;

    private String requesterProcessTypeCode;

    private String requesterProcessReferenceNumber;

    private List<BaseDTO> facts;

    public String getBusinessDomainPartyNumber() {
        return businessDomainPartyNumber;
    }

    public void setBusinessDomainPartyNumber(String businessDomainPartyNumber) {
        this.businessDomainPartyNumber = businessDomainPartyNumber;
    }

    public String getRulePackageName() {
        return rulePackageName;
    }

    public void setRulePackageName(String rulePackageName) {
        this.rulePackageName = rulePackageName;
    }

    public String getRequesterProcessTypeCode() {
        return requesterProcessTypeCode;
    }

    public void setRequesterProcessTypeCode(String requesterProcessTypeCode) {
        this.requesterProcessTypeCode = requesterProcessTypeCode;
    }

    public String getRequesterProcessReferenceNumber() {
        return requesterProcessReferenceNumber;
    }

    public void setRequesterProcessReferenceNumber(
            String requesterProcessReferenceNumber) {
        this.requesterProcessReferenceNumber = requesterProcessReferenceNumber;
    }

    public List<BaseDTO> getFacts() {
        return facts;
    }

    public void setFacts(List<BaseDTO> facts) {
        this.facts = facts;
    }
}
