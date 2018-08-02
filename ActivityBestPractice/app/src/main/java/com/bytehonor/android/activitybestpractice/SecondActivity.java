package com.bytehonor.android.activitybestpractice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    private static final String TAG = "SecondActivity";

    private Button mBtnToThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Integer age = intent.getIntExtra("age", 0);

        Log.i(TAG, "name:" + name);
        Log.i(TAG, "age:" + age);

        mBtnToThird = (Button) findViewById(R.id.second_btn_to_third);

        mBtnToThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    public static void startActivity(Context context, String name, Integer age) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("age", age);
        context.startActivity(intent);
    }
}
