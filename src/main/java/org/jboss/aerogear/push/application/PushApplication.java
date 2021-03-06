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

package org.jboss.aerogear.push.application;

import java.util.List;

/**
 * Server side abstraction of a "AeroGear Unified Push" application.
 * 
 *  This representation can be configured to have several/different/multiple mobile applications,
 *  to receive messages.
 *  
 */
// Name it ServerApplication?
public interface PushApplication {

    
    // some name/desc....
    void setName(String name);
    String getName();
    void setDescription(String description);
    String getDescription();
    
    /**
     * Returns the App-Key, generated by the AG server. The App-Key is used to send messages to a server application,
     * which broadcasts them to the (desired) mobile application that are associated with the app
     */
    // app id key, generated by the AG server
    String getApplicationKey();

    /**
     * List of all mobile variations for this server side abstraction (e.g. one iOS app and/oe one Android app)
     */
    List<MobileApplication> getMobileApplications();
    
    /**
     * Adds a new {@link MobileApplication} to the server abstraction;
     * @param mobileApp
     */
    void addMobileApplication(MobileApplication mobileApp);

    /**
     * Removes a {@link MobileApplication} to the server abstraction;
     */
    void removeMobileApplication(MobileApplication mobileApp);
    
}
