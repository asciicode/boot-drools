package com.ascii.framework.base.kie.dto;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.util.Base64Utils;

public class KieRuleResourceDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kieRulePath;

    private String kieRuleContent;

    public byte[] getKieRuleContentInBytes() {
        return Base64Utils.decodeFromString(kieRuleContent);
    }

    public void setKieRuleContentInBytes(byte[] kieRuleContentInBytes) {
        kieRuleContent = Base64Utils.encodeToString(kieRuleContentInBytes);
    }

    public String getKieRulePath() {
        return kieRulePath;
    }

    public void setKieRulePath(String kieRulePath) {
        this.kieRulePath = kieRulePath;
    }

    public String getKieRuleContent() {
        return kieRuleContent;
    }

    public void setKieRuleContent(String kieRuleContent) {
        this.kieRuleContent = kieRuleContent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kieRulePath, kieRuleContent);
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object instanceof KieRuleResourceDTO) {
            KieRuleResourceDTO other = (KieRuleResourceDTO) object;
            result = Objects.equals(kieRulePath, other.kieRulePath)
                    && Objects.equals(kieRuleContent, other.kieRuleContent);
        }
        return result;
    }
}
