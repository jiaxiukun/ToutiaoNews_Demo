package com.bw.toutiaonews_demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.toutiaonews_demo.utils.IntentAllUtils;

public class ZhuCeActivity extends Activity implements View.OnClickListener{

    private EditText num;
    private TextView login;
    private Button next;
    private ImageView back;
    private CheckBox box;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        initview();
        back.setOnClickListener(this);
        next.setOnClickListener(this);
        login.setOnClickListener(this);


    }

    private void initview() {
        num = (EditText) findViewById(R.id.register_num);
        login = (TextView) findViewById(R.id.login);
        next = (Button) findViewById(R.id.register_next);
        back = (ImageView) findViewById(R.id.register_back);
        box= (CheckBox) findViewById(R.id.register_cb);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register_back:
                IntentAllUtils.getInstance().intent(this,DengluActivity.class);
                finish();
                break;
            case R.id.register_next:
                if (box.isChecked()){
                    IntentAllUtils.getInstance().intentTel(this,ZhuceNext_Activity.class,num.getText().toString().trim());
                    finish();
                }else{
                    Toast.makeText(this, "请接受协议", Toast.LENGTH_SHORT).show();
                }

                break;
            case  R.id.login:
                IntentAllUtils.getInstance().intent(this,DengluActivity.class);
                finish();
                break;
            default:
                break;
        }

    }


}
