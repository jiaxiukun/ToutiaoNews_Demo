package com.bw.toutiaonews_demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.toutiaonews_demo.bean.Login;
import com.bw.toutiaonews_demo.network.HttpUtils;
import com.bw.toutiaonews_demo.utils.ApiUtils;
import com.bw.toutiaonews_demo.utils.IntentAllUtils;

import java.io.IOException;

public class DengluActivity extends Activity {
    private EditText num;
    private EditText pwd;
    private TextView register;
    private TextView forgetPwd;
    private Button login;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);
        initview();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentAllUtils.getInstance().intent(DengluActivity.this, ZhuCeActivity.class);
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tel = num.getText().toString().trim();
                String password = pwd.getText().toString().trim();
                HttpUtils.getAsyn(ApiUtils.DENGLU + "?username=" + tel + "&password=" + password + "&postkey=1503d", null, Login.class, new HttpUtils.HttpCallBack<Login>() {
                    @Override
                    public void onSuccess(Login login) {
                        if (login.getRet_code() == 200) {
                            Toast.makeText(DengluActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(DengluActivity.this, login.getRet_msg(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(IOException e) {

                    }
                });
            }
        });


    }

    private void initview() {
        num = (EditText) findViewById(R.id.login_num);
        pwd = (EditText) findViewById(R.id.login_pwd);
        register = (TextView) findViewById(R.id.login_tv_register);
        forgetPwd = (TextView) findViewById(R.id.login_tv_forget_pwd);
        login = (Button) findViewById(R.id.login_bt);
        back = (ImageView) findViewById(R.id.login_back);
    }
}
