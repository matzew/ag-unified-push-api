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
