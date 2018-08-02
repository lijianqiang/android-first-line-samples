package com.bytehonor.android.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private IntentFilter intentFilter;

    private NetworkChangeReceiver changeReceiver;

    private Button mBtnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnSend = (Button) findViewById(R.id.btn_send_broadcast);
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.bytehonor.android.broadcasttest.MY_BROADCAST");
                intent.setPackage(getPackageName()); // 8.0后必须指定Package
                sendBroadcast(intent);
                Log.i(TAG, "mBtnSend");
            }
        });

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        changeReceiver = new NetworkChangeReceiver();
        registerReceiver(changeReceiver, intentFilter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(changeReceiver);
    }

    class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                Toast.makeText(context, "network is connected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "network not connected", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
