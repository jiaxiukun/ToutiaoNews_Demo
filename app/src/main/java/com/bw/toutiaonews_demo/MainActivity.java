package com.bw.toutiaonews_demo;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.bw.toutiaonews_demo.fraggments.MentLeftFragment;
import com.bw.toutiaonews_demo.fraggments.MenuRightFragment;
import com.bw.toutiaonews_demo.fraggments.events.EventActivity;
import com.bwei.slidingmenu.SlidingMenu;
import com.bwei.slidingmenu.app.SlidingFragmentActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends SlidingFragmentActivity {

    private SlidingMenu slidingMenu;
    private List<Fragment> list = new ArrayList<Fragment>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        initLeftRight();

        EventBus.getDefault().register(this);
        initGrayBackground();
    }

    private void initLeftRight() {

     /*   IndexFragment indexFragment = new IndexFragment();

        if (!indexFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, indexFragment).commit();
        }

        getSupportFragmentManager().beginTransaction().show(indexFragment).commit();*/

        Fragment legtFragment = new MentLeftFragment();
        setBehindContentView(R.layout.left_menu_frame);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_leftmenu_id, legtFragment).commit();
        slidingMenu = getSlidingMenu();
        //设置滑动方式
        slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);
        // 设置触摸屏幕的模式
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        // 设置阴影的宽度
        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        // 设置slidingmenu边界的阴影图片
        slidingMenu.setShadowDrawable(R.drawable.shadow);
        // 设置滑动菜单视图的宽度
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        slidingMenu.setFadeDegree(0.35f);
        //设置右边的二级侧滑菜单
        MenuRightFragment menuRightFragment = new MenuRightFragment();
        slidingMenu.setSecondaryMenu(R.layout.right_menu_frame);

        getSupportFragmentManager().beginTransaction().replace(R.id.id_frame_rightmenu, menuRightFragment).commit();
    }

    WindowManager windowManager;
    WindowManager.LayoutParams layoutParams;
    View view;

    public void initGrayBackground() {
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        //设置失去焦点不能触摸以及透明度
        layoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_APPLICATION, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, PixelFormat.TRANSPARENT);
        //用一个view来承接更改
        view = new View(this);
        view.setBackgroundResource(R.color.color_window);
    }


    //日夜间模式切换
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventActivity(EventActivity event) {

        if (event.isWhite()) {
            //日间模式
            windowManager.removeViewImmediate(view);
        } else {
            //夜间模式
            windowManager.addView(view, layoutParams);
        }
      /*  //更改字体颜色
        switchTextViewColor((ViewGroup) getWindow().getDecorView(), event.isWhite());
        IndexFragment indexFragment = (IndexFragment) list.get(0);
        indexFragment.changeMode(event.isWhite());*/

    }

    /**
     * 遍历出所有的textView设置对应的颜色
     *
     * @param view
     */
    public void switchTextViewColor(ViewGroup view, boolean white) {
//        getChildCount 获取ViewGroup下view的个数
//        view.getChildAt(i) 根据下标获取对应的子view
        for (int i = 0; i < view.getChildCount(); i++) {
            if (view.getChildAt(i) instanceof ViewGroup) {
                switchTextViewColor((ViewGroup) view.getChildAt(i), white);
            } else if (view.getChildAt(i) instanceof TextView) {
                //设置颜色
                int resouseId;
                TextView textView = (TextView) view.getChildAt(i);
                if (white) {
                    resouseId = getResources().getColor(R.color.gray_plus);
                } else {
                    resouseId = getResources().getColor(R.color.tablayout_bg);
                }
                textView.setTextColor(resouseId);
            }
        }
    }
}