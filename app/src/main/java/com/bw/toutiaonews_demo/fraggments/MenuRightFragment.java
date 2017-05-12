package com.bw.toutiaonews_demo.fraggments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.toutiaonews_demo.R;

/**
 * Created by 贾秀坤 on 2017/5/10.
 */

public class MenuRightFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.menuright_fragment, container, false);
        return view;
    }

    public void changeMode(boolean white) {
        if (white) {
            view.setBackgroundColor(getResources().getColor(R.color.iwhite));
        } else {
            view.setBackgroundColor(getResources().getColor(R.color.night_up));
        }
    }
}