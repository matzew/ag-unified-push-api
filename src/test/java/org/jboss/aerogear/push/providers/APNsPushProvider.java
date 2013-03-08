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

package org.jboss.aerogear.push.providers;

import java.util.Set;

import org.jboss.aerogear.push.ApplicationPushProvider;
import org.jboss.aerogear.push.registration.DeviceRegistrationService;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;

public final class APNsPushProvider implements ApplicationPushProvider {
    
    // that is a PER APP thing....
    private static final ApnsService service = APNS.newService()
            // TODO: better storage...
            .withCert("/Users/matzew/Desktop/CERT.p12", "top secret")
            .withSandboxDestination()
            .build();
    
    // not that good:
    private final DeviceRegistrationService deviceService = new DeviceRegistrationService();

    public APNsPushProvider() {};

    public void push(String simpleMessage) {
        String payload = APNS.newPayload().alertBody(simpleMessage).customField("fooo", "VE").badge(-1).sound("default").build();

        Set<String> iOStokens = deviceService.allTokensForOS("iOS");
        
        service.push(iOStokens, payload);
    };
}
