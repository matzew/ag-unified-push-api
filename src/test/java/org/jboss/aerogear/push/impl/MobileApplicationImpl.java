package org.jboss.aerogear.push.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.jboss.aerogear.push.application.MobileApplication;
import org.jboss.aerogear.push.application.MobileApplicationInstance;

public abstract class MobileApplicationImpl implements MobileApplication {
    
    private final List<MobileApplicationInstance> instances = new ArrayList<MobileApplicationInstance>();
    private final String aeroGearMobileAppId;
    
    public MobileApplicationImpl() {
        aeroGearMobileAppId = UUID.randomUUID().toString();
    }

    @Override
    public String getAeroGearMobileAppId() {
        return aeroGearMobileAppId;
    }

    @Override
    public List<MobileApplicationInstance> getInstances() {
        return Collections.unmodifiableList(instances);
    }

    /// DEVICE REG.......
    @Override
    public void addInstance(MobileApplicationInstance instance) {
        instances.add(instance);
    }

    @Override
    public void removeInstance(MobileApplicationInstance instance) {
        instances.remove(instance);
    }
    
    public abstract <T> void send(T message);
}
