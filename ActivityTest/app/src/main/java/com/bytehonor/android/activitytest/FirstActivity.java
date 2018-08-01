package com.bytehonor.android.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private static final String TAG = "FirstActivity";

    private Button btnIntent1;

    private Button btnIntentForResult;

    private Button btnIntent2;

    private Button btnIntent3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button btn1 = (Button) findViewById(R.id.first_btn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "first button click");
                Toast.makeText(FirstActivity.this, "Hello firstActiviey", Toast.LENGTH_SHORT).show();
            }
        });

        btnIntent1 = (Button) findViewById(R.id.btn_intent_1);
        btnIntent2 = (Button) findViewById(R.id.btn_intent_2);

        btnIntent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", "Hello boy");
                startActivity(intent);
            }
        });

        btnIntent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.bytehonor.android.activitytest.ACTION_START_TEST");
                intent.addCategory("com.bytehonor.android.activitytest.CATEGORY_TEST");
                startActivity(intent);
            }
        });

        btnIntent3 = (Button) findViewById(R.id.btn_intent_3);
        btnIntent3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);
            }
        });

        btnIntentForResult = (Button) findViewById(R.id.btn_intent_for_resut);
        btnIntentForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent, 123);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                break;
            case R.id.menu_sub:
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 123:
                Log.i(TAG, "ResultCode:" + resultCode);
                if (resultCode == RESULT_OK) {
                    String info = data.getStringExtra("data_return");
                    Log.i(TAG, "the data return is:" + info);
                }
                break;

            default:
                break;
        }
    }
}
