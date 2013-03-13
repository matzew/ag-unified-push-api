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

import java.util.List;

import org.jboss.aerogear.push.application.PushApplication;
import org.jboss.aerogear.push.application.MobileApplication;
import org.jboss.aerogear.push.application.MobileApplicationInstance;

/**
 * Sends push messages to different "Applications"
 */


// TODO....... name.......!!!!
public interface Sender {
    
    /**
     * Sends message to all registered <code>PushApplication</code>s... 
     */
    <T> void sendMessage(T message);
    
    /**
     * Sends message to a specfic <code>PushApplication</code>... 
     */
    <T> void sendMessageToApplication(T message, PushApplication app);

    /**
     * Sends message to a filtered list of <code>PushApplication</code>s... 
     */
    <T> void sendMessageToApplications(T message, List<PushApplication> apps);

    /**
     * Sends message to a specfic <code>MobileApplication</code>... 
     */
    <T> void sendMessageToMobileApplication(T message, MobileApplication app);

    /**
     * Sends message to a filtered list of <code>MobileApplication</code>s... 
     */
    <T> void sendMessageToMobileApplications(T message, List<MobileApplication> apps);
    
    /**
     * Sends message to a specfic device 
     */
    <T> void sendMessageToDevice(T message, MobileApplicationInstance installation);

    /**
     * Sends message to a filtered list of devices 
     */
    <T> void sendMessageToDevices(T message, List<MobileApplicationInstance> installations);
}
