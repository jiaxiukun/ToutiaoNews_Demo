package com.bw.toutiaonews_demo.fraggments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.toutiaonews_demo.R;
import com.bw.toutiaonews_demo.adapters.IndexFragmentAdapter;
import com.bw.toutiaonews_demo.base.BaseFragment;

/**
 * Created by 贾秀坤 on 2017/5/10.
 */

public class IndexFragment extends BaseFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private IndexFragmentAdapter indexFragmentAdapter;

    //推荐
    public static IndexFragment newInstance(int type) {
        IndexFragment fragment = new IndexFragment();
        Bundle args = new Bundle();
        args.putInt("args", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.index_fragment, container, false);

        initview(view);

        return view;
    }

    private void initview(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.index_tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.index_viewpager);
        indexFragmentAdapter = new IndexFragmentAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(indexFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        setWhiteMode();
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    //切换夜间模式
    public void changeMode(boolean white) {

        if (white) {
            tabLayout.setBackgroundColor(getResources().getColor(R.color.tablayout_bg));
            setWhiteMode();
        } else {
            tabLayout.setBackgroundColor(getResources().getColor(R.color.nignt_middle));
            setNightMode();
        }
    }

    private void setWhiteMode() {
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.title_color));
        tabLayout.setTabTextColors(getResources().getColor(R.color.gray), getResources().getColor(R.color.title_color));
    }

    private void setNightMode() {
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.title_color));
        tabLayout.setTabTextColors(getResources().getColor(R.color.gray), getResources().getColor(R.color.night_title_color));
    }
}