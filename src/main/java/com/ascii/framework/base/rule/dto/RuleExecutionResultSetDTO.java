package com.ascii.framework.base.rule.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RuleExecutionResultSetDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Map<String, RuleExecutionResultDTO> ruleExecutionResults = new LinkedHashMap<>();

    private final List<RuleExecutionResultDTO> rawRuleExecutionResults = new LinkedList<>();

    private final List<String> statuses = Arrays.asList("PASS", "WARNING",
            "FAIL", "ERROR");

    private String checkProcessNumber;

    private String businessDomainPartyNumber;

    private String rulePackageNumber;

    private String requesterProcessTypeCode;

    private String requesterProcessReferenceNumber;

    private String status;

    private String returnValue;

    private String statusRemarks;

    private String overrideWithOptionResponseType;

    private List<String> overrideWithOptionMessages = new ArrayList<>();

    private String overrideWithAttestation;

    public Map<String, RuleExecutionResultDTO> getRuleExecutionResults() {
        return ruleExecutionResults;
    }

    public void add(RuleExecutionResultDTO executionResultDTO) {
        rawRuleExecutionResults.add(executionResultDTO);
    }

    public void postProcess(String agendaGroupName, String ruleName) {
        for (RuleExecutionResultDTO ruleExecutionResultDTO : rawRuleExecutionResults) {
            ruleExecutionResultDTO.setAgendaGroupName(agendaGroupName);
            ruleExecutionResultDTO.setRuleName(ruleName);
            ruleExecutionResults.put(ruleName, ruleExecutionResultDTO);
            if (status == null
                    || statuses.indexOf(ruleExecutionResultDTO.getRuleStatus()) > statuses
                            .indexOf(status)) {
                status = ruleExecutionResultDTO.getRuleStatus();
                returnValue = ruleExecutionResultDTO.getReturnValue();
                statusRemarks = ruleExecutionResultDTO.getStatusRemarks();
                overrideWithOptionResponseType = ruleExecutionResultDTO
                        .getOverrideWithOptionResponseType();
                overrideWithOptionMessages = ruleExecutionResultDTO
                        .getOverrideWithOptionMessages();
                overrideWithAttestation = ruleExecutionResultDTO
                        .getOverrideWithAttestation();
            }
        }
        rawRuleExecutionResults.clear();
    }

    public String getCheckProcessNumber() {
        return checkProcessNumber;
    }

    public void setCheckProcessNumber(String checkProcessNumber) {
        this.checkProcessNumber = checkProcessNumber;
    }

    public String getBusinessDomainPartyNumber() {
        return businessDomainPartyNumber;
    }

    public void setBusinessDomainPartyNumber(String businessDomainPartyNumber) {
        this.businessDomainPartyNumber = businessDomainPartyNumber;
    }

    public String getRulePackageNumber() {
        return rulePackageNumber;
    }

    public void setRulePackageNumber(String rulePackageNumber) {
        this.rulePackageNumber = rulePackageNumber;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    public String getStatusRemarks() {
        return statusRemarks;
    }

    public void setStatusRemarks(String statusRemarks) {
        this.statusRemarks = statusRemarks;
    }

    public String getOverrideWithOptionResponseType() {
        return overrideWithOptionResponseType;
    }

    public void setOverrideWithOptionResponseType(
            String overrideWithOptionResponseType) {
        this.overrideWithOptionResponseType = overrideWithOptionResponseType;
    }

    public List<String> getOverrideWithOptionMessages() {
        return overrideWithOptionMessages;
    }

    public void setOverrideWithOptionMessages(
            List<String> overrideWithOptionMessages) {
        this.overrideWithOptionMessages = overrideWithOptionMessages;
    }

    public String getOverrideWithAttestation() {
        return overrideWithAttestation;
    }

    public void setOverrideWithAttestation(String overrideWithAttestation) {
        this.overrideWithAttestation = overrideWithAttestation;
    }
}
