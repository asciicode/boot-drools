package com.ascii.framework.base.kie.service;

public interface RuleManagementService {

    void buildAndRefresh();

    void refresh(boolean forceBuild);

}
