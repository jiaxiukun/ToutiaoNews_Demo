package com.bw.toutiaonews_demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description
 * Created by 张芸艳 on 2017/4/25.
 */

public class StringUtils {
    private static StringUtils stringUtils;



    public static StringUtils getInstance() {
        if (stringUtils == null) {
            synchronized (StringUtils.class) {
                if (stringUtils == null) {
                    stringUtils = new StringUtils();
                }
            }
        }
        return stringUtils;
    }

    private StringUtils() {
    }
    public String SubString (String string){
        if (string.length()>12){
            string=string.substring(0,12)+"…";
        }

        return string;
    }
    public String SubStringLong (String string){
        if (string.length()>32){
            string=string.substring(0,32)+"…";
        }

        return string;
    }
    public String SubStringCount (String string){
        if (string.length()>4){
            string=string.substring(0,4)+"万";
        }

        return string;
    }
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
}
