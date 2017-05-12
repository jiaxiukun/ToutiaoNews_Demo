package com.bw.toutiaonews_demo.fraggments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bw.toutiaonews_demo.R;
import com.bw.toutiaonews_demo.base.BaseFragment;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

/**
 * Created by 贾秀坤 on 2017/5/10.
 */

public class MenuRightFragment extends BaseFragment implements View.OnClickListener {
    private ImageView imageViewqq;
    private ImageView imageViewweibo;
    private ImageView imageViewtencent;
    private UMShareAPI umShareAPI;
    private ShareListener shareListener ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.menuright_fragment,container,false);
        initview(view);
        return view;
    }

    private void initview(View view) {

        imageViewqq = (ImageView) view.findViewById(R.id.menuright_qq);
        imageViewqq.setOnClickListener(this);
        imageViewweibo = (ImageView) view.findViewById(R.id.menuright_weibo);
        imageViewweibo.setOnClickListener(this);
        imageViewtencent = (ImageView) view.findViewById(R.id.menuright_tencent);
        imageViewtencent.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.menuright_qq:
                shareListener.share(SHARE_MEDIA.QQ);
                break;
            case R.id.menuright_weibo:
                shareListener.share(SHARE_MEDIA.SINA);
                break;
            case R.id.menuright_tencent:
                shareListener.share(SHARE_MEDIA.TENCENT);
                break;
        }
    }

    public interface ShareListener{
        public void share(SHARE_MEDIA share_media);
    }
    public  void setShareListener(ShareListener listener){
        this.shareListener=listener;
    }
}
