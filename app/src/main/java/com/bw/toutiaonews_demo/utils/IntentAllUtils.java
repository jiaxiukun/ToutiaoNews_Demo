package com.bw.toutiaonews_demo.utils;


import android.content.Context;
import android.content.Intent;
/**
 * Created by 贾秀坤 on 2017/5/10.
 */

public class IntentAllUtils {

    private Object object;
    private String tel;
    private static IntentAllUtils intentAllUtils;


    public static IntentAllUtils getInstance() {
        if (intentAllUtils == null) {
            synchronized (IntentAllUtils.class) {
                if (intentAllUtils == null) {
                    intentAllUtils = new IntentAllUtils();
                }
            }
        }
        return intentAllUtils;
    }

    private IntentAllUtils() {
    }

    public void intentAll(Context context, Class classType, Object object) {
        Intent intent = new Intent(context, classType);
        this.object = object;
        context.startActivity(intent);
    }

    public void intentTel(Context context, Class classType, String tel) {
        Intent intent = new Intent(context, classType);
        this.tel = tel;
        context.startActivity(intent);
    }
    public void intent(Context context, Class classType) {
        Intent intent = new Intent(context, classType);
        context.startActivity(intent);
    }

    public Object getObject() {
        return object;
    }

    public String getTel() {
        return tel;
    }

}
