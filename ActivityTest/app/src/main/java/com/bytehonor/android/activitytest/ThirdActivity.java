package com.bytehonor.android.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    private Button btnThird1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btnThird1 = (Button) findViewById(R.id.btn_third_1);

    }
}
