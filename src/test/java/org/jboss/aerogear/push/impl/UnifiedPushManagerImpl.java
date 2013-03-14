package org.jboss.aerogear.push.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jboss.aerogear.push.UnifiedPushManager;
import org.jboss.aerogear.push.application.PushApplication;

public class UnifiedPushManagerImpl implements UnifiedPushManager {
    
    private final Map<String, PushApplication> pushApps = new LinkedHashMap<String, PushApplication>(); 

    @Override
    public void registerPushApplication(PushApplication pushApplication) {
        pushApps.put(pushApplication.getApplicationKey(), pushApplication);
    }

    @Override
    public void unregisterPushApplication(PushApplication pushApplication) {
        pushApps.remove(pushApplication.getApplicationKey());
    }

    @Override
    public PushApplication getPushApplication(String applicationKey) {
        return pushApps.get(applicationKey);
    }

    @Override
    public List<PushApplication> getPushApplications() {
        List<PushApplication> retVal = new ArrayList<PushApplication>(pushApps.values());
        return Collections.unmodifiableList(retVal);
    }

}
