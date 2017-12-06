package com.example.android.sipservice;

import android.content.Context;
import android.content.IntentFilter;
import android.net.sip.SipAudioCall;
import android.net.sip.SipManager;
import android.net.sip.SipProfile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    public String address = null; //sip address
    public SipManager sipManager = null;
    public SipProfile sipProfile = null;
    public SipAudioCall sipAudioCall = null;
    public CallReceiver CallReceiver;
    private static final int CALL = 1; //call button id
    private static final int SET_AUTH_INFO = 2; //set auth data button id
    private static final int SETTINGS = 3; //set settings button id
    private static final int END_CALL = 4; //end call button id
    public static Context ctx;

    /**
     * Load layout
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        ctx = this;
        create();
    }


    public void create() {
        ToggleButton pushToTalkButton = (ToggleButton) findViewById(R.id.talking);
        pushToTalkButton.setOnTouchListener(this);

        IntentFilter filter = new IntentFilter();
        filter.addAction("android.SipDemo.INCOMING_CALL");
        CallReceiver = new CallReceiver();
        this.registerReceiver(CallReceiver, filter);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    public void updateStatus(SipAudioCall incomingCall) {
    }
}
