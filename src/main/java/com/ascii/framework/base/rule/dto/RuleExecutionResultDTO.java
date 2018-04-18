package com.ascii.framework.base.rule.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RuleExecutionResultDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String agendaGroupName;

    private String ruleName;

    private String ruleStatus;

    private String returnValue;

    private String statusRemarks;

    private String overrideWithOptionResponseType;

    private List<String> overrideWithOptionMessages = new ArrayList<>();

    private String overrideWithAttestation;

    public void addAllOverrideWithOptionMessages(
            String... overrideWithOptionMessages) {
        this.overrideWithOptionMessages.addAll(Arrays
                .asList(overrideWithOptionMessages));
    }

    public String getAgendaGroupName() {
        return agendaGroupName;
    }

    public void setAgendaGroupName(String agendaGroupName) {
        this.agendaGroupName = agendaGroupName;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleStatus() {
        return ruleStatus;
    }

    public void setRuleStatus(String ruleStatus) {
        this.ruleStatus = ruleStatus;
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

    public void setStatusRemarksList(String... statusRemarksList) {
        StringBuilder statusRemarks = new StringBuilder("");
        for (String remark : statusRemarksList) {
            if (statusRemarks.length() > 0) {
                statusRemarks.append("\n");
            }
            statusRemarks.append(remark);
        }
        this.statusRemarks = statusRemarks.toString();
    }

}
