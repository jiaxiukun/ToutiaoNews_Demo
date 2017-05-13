package com.bw.toutiaonews_demo.utils;

import android.app.Application;

import com.igexin.sdk.PushManager;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * date:2017/5/10
 * author:徐帅(acer)
 * funcation:
 */

public class IApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // com.getui.demo.DemoPushService 为第三方自定义推送服务
        PushManager.getInstance().initialize(this.getApplicationContext(),com.bw.toutiaonews_demo.DemoPushService.class);
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(),com.bw.toutiaonews_demo.DemoIntentService.class);

        UMShareAPI.get(this);
        Config.DEBUG = true;
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }
}