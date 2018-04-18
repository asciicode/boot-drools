package com.ascii.framework.base.kie.service;

public interface KieContainerService extends RuleManagementService {

    void executeWithNewKieSession(String businessDomainPartyNumber,
            KieSessionCallback callback);
}
