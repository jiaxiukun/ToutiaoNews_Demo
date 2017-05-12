package com.bw.toutiaonews_demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.toutiaonews_demo.bean.Register;
import com.bw.toutiaonews_demo.network.HttpUtils;
import com.bw.toutiaonews_demo.utils.ApiUtils;
import com.bw.toutiaonews_demo.utils.IntentAllUtils;

import java.io.IOException;


public class ZhuceNext_Activity extends Activity implements View.OnClickListener{

    private EditText num;
    private EditText pwd;
    private Button login;
    private ImageView back;
    private TextView code;
    private String random;
    private IntentAllUtils instance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce_next_);
        instance = IntentAllUtils.getInstance();
        initView();
        int random1=(int)(Math.random()*10);
        int random2=(int)(Math.random()*10);
        int random3=(int)(Math.random()*10);
        int random4=(int)(Math.random()*10);
        random = random1+""+random2+random3+random4;
        code.setText(random);
        back.setOnClickListener(this);
        login.setOnClickListener(this);

    }
    private void initView() {
        login = (Button) findViewById(R.id.reg_login);
        back = (ImageView) findViewById(R.id.reg_back);
        code= (TextView) findViewById(R.id.reg_code);
        num= (EditText) findViewById(R.id.reg_num);
        pwd= (EditText) findViewById(R.id.reg_pwd);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.reg_back:
                IntentAllUtils.getInstance().intent(this, ZhuCeActivity.class);
                finish();
                break;
            case R.id.reg_login:
                String codeNum = num.getText().toString().trim();
                String password = pwd.getText().toString().trim();
                if (random.equals(codeNum)) {
                    String tel = instance.getTel();
                    HttpUtils.getAsyn(ApiUtils.ZHUCE + "?phone=" + tel + "&password=" + password + "&postkey=1503d", null, Register.class, new HttpUtils.HttpCallBack<Register>() {
                        @Override
                        public void onSuccess(Register register) {
                            if (register.getRet_code() == 200) {
                                instance.intent(ZhuceNext_Activity.this, DengluActivity.class);
                                Toast.makeText(ZhuceNext_Activity.this, "注册成功", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(ZhuceNext_Activity.this, register.getRet_msg(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(IOException e) {

                        }
                    });

                } else {
                    Toast.makeText(this, "验证码输入错误,请重新输入", Toast.LENGTH_SHORT).show();
                }


                break;
            default:
                break;
        }
    }
    }