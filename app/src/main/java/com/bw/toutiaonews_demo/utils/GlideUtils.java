package com.bw.toutiaonews_demo.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bw.toutiaonews_demo.R;


public class GlideUtils {
    private static GlideUtils glideUtils;

    public static GlideUtils getInstance() {
        if (glideUtils == null) {
            synchronized (GlideUtils.class) {
                if (glideUtils == null) {
                    glideUtils = new GlideUtils();
                }
            }
        }
        return glideUtils;
    }

    private GlideUtils() {
    }

    public void haveCache(String url, ImageView view, Context context) {
        Glide.with(context).load(url)
                .placeholder(R.drawable.image_loading)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.image_loading)
                .fitCenter()
                .into(view);

    }

    public void haveCacheLarger(String url, ImageView view, Context context) {
        Glide.with(context).load(url)
                .placeholder(R.drawable.profile_bg)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.profile_bg)
                .fitCenter()
                .into(view);

    }

    public void havaRound(String url, ImageView view, Context context) {
        Glide.with(context).load(url)
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .transform(new GlideRound(context, 30))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view);
    }
}