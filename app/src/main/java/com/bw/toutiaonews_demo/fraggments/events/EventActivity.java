package com.bw.toutiaonews_demo.fraggments.events;

/**
 * Created by 贾秀坤 on 2017/5/10.
 * 写一个类来存切换日夜模式
 */

public class EventActivity {

    public boolean white;

    public EventActivity(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;

    }
}