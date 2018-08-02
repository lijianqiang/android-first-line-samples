package com.bytehonor.android.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "MyBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "MyBroadcastReceiver onReceive");
        Toast.makeText(context, "my broadcast receive", Toast.LENGTH_SHORT).show();
    }
}
