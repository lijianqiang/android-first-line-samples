package com.bytehonor.android.activitylifecircletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button btnStartNormal;

    private Button btnStartDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "-- onCreate --");

        if (savedInstanceState != null) {
            String tmp = savedInstanceState.getString("data_key");
            Log.i(TAG, "temp storage:" + tmp);
        }

        btnStartNormal = (Button) findViewById(R.id.btn_start_normal);

        btnStartNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });

        btnStartDialog = (Button) findViewById(R.id.btn_start_dialog);

        btnStartDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "-- onStart --");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "-- onStop --");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "-- onDestroy --");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "-- onPause --");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "-- onResume --");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "-- onRestart --");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String temp = "Something you just typed";
        outState.putString("data_key", temp);
    }
}
