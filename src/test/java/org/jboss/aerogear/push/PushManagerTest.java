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

package org.jboss.aerogear.push;

import org.jboss.aerogear.push.impl.PushManagerImpl;
import org.jboss.aerogear.push.providers.APNsPushProvider;
import org.jboss.aerogear.push.providers.GCMPushProvider;
import org.junit.Before;
import org.junit.Test;

public class PushManagerTest {
    
    private PushManager pushManger;
    
    @Before
    public void setup() {
        pushManger = new PushManagerImpl();
    }

    @Test
    public void simpleTestWithoutProviders() {
        pushManger.enqueue("AeroGear's Unified Push rocks!", new AcknowledgeListener() {
            @Override
            public void onDelivery(Object pushContext) {
                System.out.println("Submitted to networks");
            }
        });
    }

    @Test
    public void simpleApplePush() {
        // register one apple app:
        pushManger.registerPushProvider(new APNsPushProvider());
        
        // send simple message
        pushManger.enqueue("AeroGear's Unified Push rocks!", new AcknowledgeListener() {
            @Override
            public void onDelivery(Object pushContext) {
                System.out.println("Submitted to networks");
            }
        });
    }

    @Test
    public void simpleGooglePush() {
        // register one Android app:
        pushManger.registerPushProvider(new GCMPushProvider());
        
        // send simple message
        pushManger.enqueue("AeroGear's Unified Push rocks!", new AcknowledgeListener() {
            @Override
            public void onDelivery(Object pushContext) {
                System.out.println("Submitted to networks");
            }
        });
    }

    @Test
    public void multipleAppPush() {
        // register one apple app:
        pushManger.registerPushProvider(new APNsPushProvider());
        // register one Android app:
        pushManger.registerPushProvider(new GCMPushProvider());
        
        // send simple message
        pushManger.enqueue("AeroGear's Unified Push rocks!", new AcknowledgeListener() {
            @Override
            public void onDelivery(Object pushContext) {
                System.out.println("Submitted to networks");
            }
        });
    }

}
