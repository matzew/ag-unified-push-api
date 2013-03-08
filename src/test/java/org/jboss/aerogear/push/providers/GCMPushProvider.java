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

package org.jboss.aerogear.push.providers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jboss.aerogear.push.ApplicationPushProvider;
import org.jboss.aerogear.push.registration.DeviceRegistrationService;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Sender;

public class GCMPushProvider implements ApplicationPushProvider {

    private static final Sender sender = new Sender("dasdasdsaadsadsadsadsadsadsadsadsdasdas"); 

    // IMPROVE IT:
    private final DeviceRegistrationService service = new DeviceRegistrationService();
    
    @Override
    public void push(String simpleMessage) {
        
        // the payload, stored in the map 
        Message msg = new Message.Builder().addData("text", simpleMessage).build();
        
        try {
            List<String> devices = new ArrayList<String>();

            // add all the androids:
            devices.addAll(service.allTokensForOS("android"));
            
            sender.send(msg, devices, 0);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
