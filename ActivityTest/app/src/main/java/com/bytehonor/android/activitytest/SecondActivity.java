package com.bytehonor.android.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    private Button btnResutl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");

        Log.i(TAG, "data:" + data);


        btnResutl = (Button) findViewById(R.id.btn_second_return_result);
        btnResutl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "return data....");
                returnResult();
            }
        });
    }

    @Override
    public void onBackPressed() {
        returnResult();
    }

    private void returnResult() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Data Return");
        setResult(RESULT_OK, intent);
        finish();
    }
}
