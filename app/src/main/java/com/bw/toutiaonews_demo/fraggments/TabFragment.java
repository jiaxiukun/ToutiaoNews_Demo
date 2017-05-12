package com.bw.toutiaonews_demo.fraggments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.toutiaonews_demo.R;

/**
 * date:2017/5/12
 * author:徐帅(acer)
 * funcation:
 */

public class TabFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.tabfragment, null);
        return view;
    }
}