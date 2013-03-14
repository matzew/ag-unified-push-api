/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.aerogear.push.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    
    // helper.....
    protected List<String> extractTokensFromInstances() {
        final List<String> allTokens = new ArrayList<String>();
        List<MobileApplicationInstance> instances = this.getInstances();
        
        for(MobileApplicationInstance instance : instances) {
            allTokens.add(instance.getDeviceToken());
        }

        return allTokens;
    }
    
    public abstract <T> void send(T message);
}
