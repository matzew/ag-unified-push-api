package org.jboss.aerogear.push.impl;

import java.util.List;

import org.jboss.aerogear.push.application.MobileApplicationInstance;
import org.jboss.aerogear.push.application.iOSApplication;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;

public class iOSApp extends MobileApplicationImpl implements iOSApplication {

    private String certPath;
    private String phrase;
    private String appIdp;
    
    
    private ApnsService service = null;
    
    public iOSApp() {
        super();
    }
    
    @Override
    public void setAppleAppId(String appId) {
        this.appIdp = appId;
    }

    @Override
    public String getAppleAppId() {
        return appIdp;
    }


    @Override
    public void setCertificate(String pathToP12File) {
        this.certPath = pathToP12File;
    }

    @Override
    public void setPassphrase(String topsecret) {
        this.phrase = topsecret;
    }

    @Override
    public <T> void send(T message) {
        // ugly... but ... we need a better builder...
        
        service = APNS.newService()
                // TODO: better storage...
                .withCert(certPath, phrase)
                .withSandboxDestination()
                .build();
        
        
        
        List<MobileApplicationInstance> instances = this.getInstances();
        //String token = instances.get(0).getDeviceToken();
        
        String token = "8ecda0fe6d8e135cd97485a395338c1a9f4de5ee5f5fe2847d8161398e978d11";
        // send it out: 
        // blocking IO....:
        
        String payload = APNS.newPayload().alertBody(message.toString()).badge(-1).sound("default").build();
        
        System.out.println(service.push(token, payload));
        
        
        ///
        
    }

}
