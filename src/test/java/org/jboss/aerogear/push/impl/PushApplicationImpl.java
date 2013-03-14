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
