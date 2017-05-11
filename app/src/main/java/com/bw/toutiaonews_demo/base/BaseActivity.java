package com.bw.toutiaonews_demo.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.bw.toutiaonews_demo.R;

/**
 * Created by 贾秀坤 on 2017/5/10.
 */

public class BaseActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_base);
    }
}
