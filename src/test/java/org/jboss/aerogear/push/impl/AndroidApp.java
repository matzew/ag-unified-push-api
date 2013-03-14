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

import java.io.IOException;
import java.util.List;

import org.jboss.aerogear.push.application.AndroidApplication;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Sender;

public class AndroidApp extends MobileApplicationImpl implements
        AndroidApplication {
    
    private String googleAPIKey;
    private Sender sender = null;

    @Override
    public void setGoogleAPIKey(String apiKey) {
        this.googleAPIKey = apiKey;
    }

    @Override
    public <T> void send(T message) {
        // meh:
        sender = new Sender(googleAPIKey);
        
        List<String> allRegistrationIds = extractTokensFromInstances();

        Message msg = new Message.Builder().addData("text", message.toString()).addData("title", "FOOOOO").build();
        
        
        // send it out.....
        try {
            sender.send(msg, allRegistrationIds, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        

    }

}
