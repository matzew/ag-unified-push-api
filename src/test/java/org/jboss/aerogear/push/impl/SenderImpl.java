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

import java.util.List;

import org.jboss.aerogear.push.Sender;
import org.jboss.aerogear.push.application.MobileApplication;
import org.jboss.aerogear.push.application.MobileApplicationInstance;
import org.jboss.aerogear.push.application.PushApplication;

public class SenderImpl implements Sender {

    @Override
    public <T> void sendMessage(T message) {
    }

    @Override
    public <T> void sendMessageToApplication(T message, PushApplication app) {
        this.sendMessageToMobileApplications(message, app.getMobileApplications());        
    }

    @Override
    public <T> void sendMessageToApplications(T message,
            List<PushApplication> apps) {
        
        for (PushApplication pa : apps) {
            
            this.sendMessageToMobileApplications(message, pa.getMobileApplications());
        }
        
    }

    @Override
    public <T> void sendMessageToMobileApplication(T message,
            MobileApplication app) {
        MobileApplicationImpl mApp = (MobileApplicationImpl) app;

        ///
        mApp.send(message);

    }

    @Override
    public <T> void sendMessageToMobileApplications(T message,
            List<MobileApplication> apps) {
    
        for (MobileApplication app : apps) {
            this.sendMessageToMobileApplication(message, app);
        }
    }





    @Override
    public <T> void sendMessageToDevice(T message,
            MobileApplicationInstance installation) {
    }

    @Override
    public <T> void sendMessageToDevices(T message,
            List<MobileApplicationInstance> installations) {
    }

}
