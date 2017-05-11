package com.bw.toutiaonews_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ZhuceNext_Activity extends Activity {

    private Button btnbegin;
    private Button btndl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce_next_);
        btnbegin = (Button) findViewById(R.id.btn_next_begin);
        btndl = (Button) findViewById(R.id.btn_next_dl);

        btndl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ZhuceNext_Activity.this,DengluActivity.class);
                startActivity(intent);
            }
        });

    }
}
