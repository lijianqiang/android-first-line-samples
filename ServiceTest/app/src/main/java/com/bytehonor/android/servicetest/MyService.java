package com.bytehonor.android.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "MyService";

    private DownloadBinder binder = new DownloadBinder();

    class DownloadBinder extends Binder {

        public void startDownload() {
            Log.i(TAG, "DownloadBinder startDownload");
        }

        public int getProcess() {
            Log.i(TAG, "DownloadBinder getProcess");
            return 0;
        }

    }



    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }


}
