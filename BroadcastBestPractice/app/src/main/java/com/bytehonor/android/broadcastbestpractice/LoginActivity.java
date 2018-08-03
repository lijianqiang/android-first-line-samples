package com.bytehonor.android.broadcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginActivity";

    private EditText mEditName;

    private EditText mEditPassword;

    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEditName = (EditText) findViewById(R.id.edit_user_name);
        mEditPassword = (EditText) findViewById(R.id.edit_user_password);

        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mEditName.getText().toString();
                String password = mEditPassword.getText().toString();

                if (TextUtils.isEmpty(name)) {
                    showToast("user name is empty");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    showToast("user password is empty");
                    return;
                }

                if ("admin".equals(name) && "123456".equals(password)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    showToast("user name or password invalid");
                }
            }
        });
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
