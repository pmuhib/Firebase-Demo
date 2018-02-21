package com.androidtutorialpoint.fcmdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Muhib.
 * Contact Number : +91 9796173066
 */
public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
    public static final String TOKEN_BROADCAST="myfcbroad";

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("MyfirstFireID", "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
       // sendRegistrationToServer(refreshedToken);

        getApplicationContext().sendBroadcast(new Intent(TOKEN_BROADCAST));
        storeToken(refreshedToken);
    }

    private void storeToken(String refreshedToken) {
        SharedPrefManager.getInstance(getApplicationContext()).storeToken(refreshedToken);
    }
}
