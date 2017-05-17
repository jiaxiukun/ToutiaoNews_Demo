package com.bw.toutiaonews_demo.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bw.toutiaonews_demo.fraggments.anyfragments.TuijianFragment;

/**
 * Created by 贾秀坤 on 2017/5/10.
 */

public class IndexFragmentAdapter extends FragmentPagerAdapter {

    //标题
    public String[] TITLE = {"推荐", "热点", "社会", "科技", "体育", "娱乐", "军事", "财经", "视频", "美女"};

    public IndexFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        TuijianFragment tuijianFragment = new TuijianFragment();

        return tuijianFragment;
    }

    @Override
    public int getCount() {
        return TITLE.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLE[position];
    }
}