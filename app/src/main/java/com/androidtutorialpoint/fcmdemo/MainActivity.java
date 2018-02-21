package com.androidtutorialpoint.fcmdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView txt_token;
    private BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_token= (TextView) findViewById(R.id.toke);
        broadcastReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                txt_token.setText(SharedPrefManager.getInstance(MainActivity.this).getToken());
            }
        };
        if(SharedPrefManager.getInstance(this).getToken()!=null) {
            txt_token.setText(SharedPrefManager.getInstance(MainActivity.this).getToken());
            Log.d("SharedID",SharedPrefManager.getInstance(this).getToken());
        }
        registerReceiver(broadcastReceiver,new IntentFilter(MyFirebaseInstanceIdService.TOKEN_BROADCAST));


    }
}
