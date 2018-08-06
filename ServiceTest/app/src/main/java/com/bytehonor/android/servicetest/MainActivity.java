package com.bytehonor.android.servicetest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private MyService.DownloadBinder downloadBinder;

    private Button mBtnStart;

    private Button mBtnStop;

    private Button mBtnBind;

    private Button mBtnUnbind;

    private Button mBtnIntentService;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(TAG, "ServiceConnection onServiceConnected");

            downloadBinder = (MyService.DownloadBinder) iBinder;
            downloadBinder.startDownload();
            downloadBinder.getProcess();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i(TAG, "ServiceConnection onServiceDisconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnStart = (Button) findViewById(R.id.btn_start);
        mBtnStop = (Button) findViewById(R.id.btn_stop);

        mBtnBind = (Button) findViewById(R.id.btn_bind);

        mBtnUnbind = (Button) findViewById(R.id.btn_unbind);

        mBtnIntentService = (Button) findViewById(R.id.btn_intent_service);

        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "startService");
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);
            }
        });

        mBtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "stopService");
                Intent intent = new Intent(MainActivity.this, MyService.class);
                stopService(intent);
            }
        });

        mBtnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "bindService");
                Intent intent = new Intent(MainActivity.this, MyService.class);
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
            }
        });

        mBtnUnbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "unbindService");
                unbindService(serviceConnection);
            }
        });

        mBtnIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "intent service Thread:" + Thread.currentThread().getId());
                MyIntentService.startActionBaz(MainActivity.this, "1", "2");

                MyIntentService.startActionFoo(MainActivity.this, "1", "2");
            }
        });
    }
}
