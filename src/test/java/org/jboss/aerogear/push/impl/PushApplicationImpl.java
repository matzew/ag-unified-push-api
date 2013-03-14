package org.jboss.aerogear.push.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.jboss.aerogear.push.application.MobileApplication;
import org.jboss.aerogear.push.application.PushApplication;

public class PushApplicationImpl implements PushApplication {
    
    private String name;
    private String description;

    private final String appKey;
    private final List<MobileApplication> mobileApps = new ArrayList<MobileApplication>();
    
    
    public PushApplicationImpl() {
        appKey = UUID.randomUUID().toString();
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getApplicationKey() {
        return this.appKey;
    }

    @Override
    public List<MobileApplication> getMobileApplications() {
        return this.mobileApps;
    }

    @Override
    public void addMobileApplication(MobileApplication mobileApp) {
        this.mobileApps.add(mobileApp);
    }

    @Override
    public void removeMobileApplication(MobileApplication mobileApp) {
        this.mobileApps.remove(mobileApp);
    }

}
