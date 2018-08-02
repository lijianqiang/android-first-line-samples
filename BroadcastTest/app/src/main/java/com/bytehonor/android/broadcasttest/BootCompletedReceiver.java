package com.bytehonor.android.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BootCompletedReceiver extends BroadcastReceiver {

    private static final String TAG = "BootCompletedReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "BootCompletedReceiver onReceive");
        Toast.makeText(context, "Boot Completed", Toast.LENGTH_SHORT).show();
    }
}
