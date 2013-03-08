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

import org.jboss.aerogear.push.AcknowledgeListener;
import org.jboss.aerogear.push.PushManager;
import org.jboss.aerogear.push.ApplicationPushProvider;

public class PushManagerImpl implements PushManager {
    
    private final List<ApplicationPushProvider> providers = new ArrayList<ApplicationPushProvider>();
    
   public PushManagerImpl() {
   }

    @Override
    public <T> void enqueue(T message, AcknowledgeListener listener) {
        
        // hack
        for (ApplicationPushProvider p : providers) {
            
            long start = System.currentTimeMillis();
            p.push((String) message);
            long end = System.currentTimeMillis();

            System.out.println("\ntook: " + (end-start) + "(ms) \n");
        }
        
        // hrm....
        if (listener != null) {
            listener.onDelivery(null);
        }
    }

    @Override
    public <T> void enqueue(T appfilter, T message) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerPushProvider(ApplicationPushProvider pp) {
        providers.add(pp);
    }

    @Override
    public void unregisterPushProvider(ApplicationPushProvider pp) {
        providers.remove(pp);
    }
}