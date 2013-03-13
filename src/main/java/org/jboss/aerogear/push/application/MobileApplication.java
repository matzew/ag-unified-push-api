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
 * Abstraction of a mobile application (e.g. iOS, Android Application or Mobile Web(JS)).
 * 
 * One instance of this type represents EXACTLY one application (e.g. Twitter-iOS What's App-Android)
 * 
 */
public interface MobileApplication {
    
    /**
     * Returns a generated ID to represent this mobile application. The ID can be used to send messages
     * to a single mobile app (e.g. only iOS users receive a push message)
     */
    // really needed ?
    String getMobileAppId();
    
    /**
     * Returns complete list of all installed instances of this mobile application 
     */
    List<MobileApplicationInstance> getInstances();
    void addInstance(MobileApplicationInstance instance);
    void removeInstance(MobileApplicationInstance instance);
    
}
