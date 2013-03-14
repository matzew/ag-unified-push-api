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
        

        List<String> allTokens = extractTokensFromInstances();
        
        String payload = APNS.newPayload().alertBody(message.toString()).badge(-1).sound("default").build();
        
        // send it out: 
        // blocking IO....:
        System.out.println(service.push(allTokens, payload));
    }
}
