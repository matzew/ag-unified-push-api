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

/**
 * Delivers/Enqueues a message to all available <code>PushProvider</code>s, like multiple Android or Apple Applications.
 */
public interface PushManager {

    /**
     * Enqueue a message to all the registered <code>PushProvider</code>s. 
     * 
     * TODO: Do we need callbacks/Future, for a successful delivery to the push systen (GCM/Apple)?
     *     We can't guarantee that the message arrives the phone, but we can see if we could give them to the networks (e.g. Apple/Google).
     */
    <T> void enqueue(T message, AcknowledgeListener listener);

    /**
     * Enqueue a message to a subset of the registered <code>PushProvider</code>s... 
     * 
     * TODO: Do we need callbacks/Future, for a successful delivery to the push systen (GCM/Apple)?
     *     We can't guarantee that the message arrives the phone, but we can see if we could give them to the networks (e.g. Apple/Google).
     */
    <T> void enqueue(T appfilter, T message);

    /**
     * Adds a <code>PushProvider</code> instance. A <code>PushProvider</code> is an abstraction of one APP-ID (Apple) or API-Key (Google).
     *
     * Each native application needs its own <code>PushProvider</code>.
     */
    void registerPushProvider(ApplicationPushProvider pp);
    
    /**
     * Removes a <code>PushProvider</code> instance.
     */
    void unregisterPushProvider(ApplicationPushProvider pp);
}
