package com.bytehonor.android.androidthreadtest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button mBtnChange;

    private TextView mTxtShow;

    private Handler handler;

    class MyHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            Log.i(TAG, "Message what:" + msg.what);

            // TODO 为何不是主线程
            Log.i(TAG, "** 3 handleMessage run at:" + Thread.currentThread().getId());
            if (msg.what == 11) {
                String obj = (String) msg.obj;
                mTxtShow.setText(obj);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnChange = (Button) findViewById(R.id.btn_change);
        mTxtShow = (TextView) findViewById(R.id.txt_show);

        handler = new MyHandler();

        Log.i(TAG, "** 0 onCreate run at:" + Thread.currentThread().getId());

        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "** 1 onClick run at:" + Thread.currentThread().getId());
                mTxtShow.setText("begin change...");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i(TAG, "** 2 run at:" + Thread.currentThread().getId());

                        try {
                            Thread.currentThread().sleep(3000L);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        Message msg = Message.obtain();
                        msg.what = 11;
                        msg.obj = "nice to meet you";
                        handler.dispatchMessage(msg);
                    }
                }).start();
            }
        });
    }
}
