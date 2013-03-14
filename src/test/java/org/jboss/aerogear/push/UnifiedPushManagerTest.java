package org.jboss.aerogear.push;

import junit.framework.Assert;

import org.jboss.aerogear.push.application.PushApplication;
import org.jboss.aerogear.push.impl.AndroidApp;
import org.jboss.aerogear.push.impl.PushApplicationImpl;
import org.jboss.aerogear.push.impl.SenderImpl;
import org.jboss.aerogear.push.impl.UnifiedPushManagerImpl;
import org.jboss.aerogear.push.impl.iOSApp;
import org.junit.Before;
import org.junit.Test;

public class UnifiedPushManagerTest {
    
    private UnifiedPushManager pushMgr;
    
    @Before
    public void setup() {
        pushMgr = new UnifiedPushManagerImpl();
    }
    
    @Test
    public void registerApplication() {
        // CREATE push app:
        PushApplication pa = new PushApplicationImpl();
        pa.setDescription("Test Push App");
        pa.setName("All The Thingz");
        
        // register it with server:
        pushMgr.registerPushApplication(pa);
    }

    @Test
    public void registerApplicationWithiOSApp() {
        // CREATE push app:
        PushApplication pa = new PushApplicationImpl();
        pa.setDescription("Test Push App");
        pa.setName("All The Thingz");

        iOSApp iosApp = new iOSApp();
        iosApp.setAppleAppId("net.wessendorf.Pusher");
        iosApp.setCertificate("/Users/matzew/Desktop/PUSHER.p12");
        iosApp.setPassphrase("foo");
        
        pa.addMobileApplication(iosApp);
        
        // register it with server:
        pushMgr.registerPushApplication(pa);
        
    }

    @Test
    public void sendNotificationTo_iOS_and_Android() {
        // CREATE push app:
        PushApplication pa = new PushApplicationImpl();
        pa.setDescription("Test Push App");
        pa.setName("All The Thingz");

        // iOS app:
        iOSApp pusher = new iOSApp();
        pusher.setAppleAppId("net.wessendorf.MyApp");
        pusher.setCertificate("/Users/matzew/Desktop/cert.p12");
        pusher.setPassphrase("yo,dude");

        // add the iOS app:
        pa.addMobileApplication(pusher);
        
        AndroidApp todoApp = new AndroidApp();
        todoApp.setGoogleAPIKey("XAUUIADDAS");

        // add the app:
        pa.addMobileApplication(todoApp);

        // register it with server:
        pushMgr.registerPushApplication(pa);
                
        // send the message to all devices/mobile apps, for this Push app"
        SenderImpl sender = new SenderImpl();
        sender.sendMessageToApplications("Yo, dude!", pushMgr.getPushApplications());

    }

}
