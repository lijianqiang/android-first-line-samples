package com.bytehonor.android.activitybestpractice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends BaseActivity {

    private Button mBtnToSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        mBtnToSecond = (Button) findViewById(R.id.first_btn_to_second);
        mBtnToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                startActivity(intent);

                SecondActivity.startActivity(FirstActivity.this, "John", 30);
            }
        });
    }
}
