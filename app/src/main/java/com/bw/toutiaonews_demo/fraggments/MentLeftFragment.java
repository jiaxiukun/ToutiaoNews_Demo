package com.bw.toutiaonews_demo.fraggments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.bw.toutiaonews_demo.R;
import com.bw.toutiaonews_demo.ZhuCeActivity;
import com.bw.toutiaonews_demo.constants.Constants;
import com.bw.toutiaonews_demo.fraggments.events.EventActivity;
import com.bw.toutiaonews_demo.utils.PreferencesUtils;
import com.kyleduo.switchbutton.SwitchButton;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.greenrobot.eventbus.EventBus;

import java.util.Map;


/**
 * Created by 贾秀坤 on 2017/5/10.
 */

public class MentLeftFragment extends Fragment implements View.OnClickListener {
    // 日 夜 切换
    private SwitchButton switchButton;
    private ImageView img_qq;
    private SwitchButton switch_btn;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.menuleft_fragment, container, false);

        view.findViewById(R.id.button_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ZhuCeActivity.class);
                startActivity(intent);
            }
        });

        img_qq = (ImageView) view.findViewById(R.id.img_qq);
        img_qq.setOnClickListener(this);

        switch_btn = (SwitchButton) view.findViewById(R.id.switch_btn);

        switch_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                //System.out.println("isChecked = " + isChecked);
                boolean mode =  PreferencesUtils.getValueByKey(getContext(), Constants.isNightMode,isChecked);
                setMode(isChecked);
                EventBus.getDefault().post(new EventActivity(mode));

                setBackground(mode);
            }
        });

        return view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        UMShareAPI.get(getActivity()).getPlatformInfo(getActivity(), SHARE_MEDIA.QQ, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {
                //System.out.println("onStart share_media = " + share_media);


            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                System.out.println("onComplete share_media = " + share_media);

                //获取资料
                String uid = map.get("uid");
                String name = map.get("name");
                String gender = map.get("gender");
                String iconurl = map.get("iconurl");
                /**
                 * 如果想在UI中显示自己QQ的图片，可以在对应的布局中写两个imageview，然后显示的时候隐藏其中一个
                 * 最后用map,imageloader来显示图片
                 */
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                System.out.println("onError SHARE_MEDIA share_media = " + share_media);
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {
                System.out.println("onCancel SHARE_MEDIA share_media = " + share_media);
            }
        });
    }
    private void setBackground(boolean white){
        if(white){
            view.setBackgroundColor(Color.WHITE);
        } else {
            //夜间
            view.setBackgroundColor(Color.BLACK);


        }
    }


    // mode true 夜 false 日
    private void setMode(boolean mode){
        PreferencesUtils.addConfigInfo(getContext(), Constants.isNightMode,mode);

    }
}