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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jboss.aerogear.push.PushApplicationRegistry;
import org.jboss.aerogear.push.application.PushApplication;

public class PushApplicationRegistryImpl implements PushApplicationRegistry {
    
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
