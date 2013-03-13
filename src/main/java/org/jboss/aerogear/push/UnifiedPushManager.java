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

/**
 * Manages all "Push applications"
 */
public interface UnifiedPushManager {
    
    /**
     * Adds a <code>PushApplication</code> instance to the Unified Push Server.
     */
    void registerPushApplication(PushApplication pushApplication);
    
    /**
     * Removes a <code>PushApplication</code> instance to the Unified Push Server.
     */
    void unregisterPushApplication(PushApplication pushApplication);
    
    /**
     * Returns a specific <code>PushApplication</code> instance, identified by its
     * applicationKey.
     */
    PushApplication getPushApplication(String applicationKey);
    
    /**
     * List of all registered <code>PushApplication</code>s...
     */
    List<PushApplication> getPushApplications();
}
