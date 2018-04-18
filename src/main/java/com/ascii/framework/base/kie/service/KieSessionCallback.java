package com.ascii.framework.base.kie.service;

import org.kie.api.runtime.KieSession;

public interface KieSessionCallback {

    void doInKieSession(KieSession kieSession);
}
