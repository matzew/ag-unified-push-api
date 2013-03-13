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

/**
 * An iOS version of the mobile app....
 */
public interface iOSApplication extends MobileApplication {
    
    /**
     * The Apple APP-ID, from the provisioning portal 
     */
    void setAppleAppId(String appId);
    String getAppleAppId();

    /**
     * The exported .p12 file from the Apple Developer portal. The file is required for establishing an APNs connection .
     */
    void setCertificate(String pathToP12File);
    
    /**
     * Passpharase for the {@link setCertificate}. The pass phrase is required for establishing an APNs connection;
     */
    void setPassphrase(String topsecret);
    
}
