package com.bw.toutiaonews_demo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.toutiaonews_demo.R;
import com.bw.toutiaonews_demo.bean.PhotoBookType1;
import com.bw.toutiaonews_demo.utils.GlideUtils;

import java.util.List;

/**
 * description
 * Created by 张芸艳 on 2017/5/11.
 */

public class Type1Adapter extends BaseAdapter {
    List<PhotoBookType1.DataBean> list;
    Context context;

    public Type1Adapter(List<PhotoBookType1.DataBean> data, Context context) {
        this.list = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderOne one;
        if (convertView == null) {
            one = new ViewHolderOne();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.qutu_lv_item, null);
            one.tv = (TextView) convertView.findViewById(R.id.qutu_lv_tv);
            one.iv = (ImageView) convertView.findViewById(R.id.qutu_lv_iv);
            one.commentNum = (TextView) convertView.findViewById(R.id.praise_comment_num);
            one.praiseNum = (TextView) convertView.findViewById(R.id.praise_zan_num);
            one.unPraiseNum = (TextView) convertView.findViewById(R.id.praise_un_zan_num);
            one.comment = (ImageView) convertView.findViewById(R.id.praise_comment);
            one.praise = (ImageView) convertView.findViewById(R.id.praise_zan);
            one.unPraise = (ImageView) convertView.findViewById(R.id.praise_un_zan);
            one.shoucang = (CheckBox) convertView.findViewById(R.id.praise_shoucang);
            one.share = (ImageView) convertView.findViewById(R.id.praise_fenxiang);
            convertView.setTag(one);
        } else {
            one = (ViewHolderOne) convertView.getTag();
        }
        one.tv.setText(list.get(position).getContent());
        one.commentNum.setText(list.get(position).getComment_count() + "");
        one.praiseNum.setText(list.get(position).getDigg_count() + "");
        one.unPraiseNum.setText(list.get(position).getBury_count() + "");
        GlideUtils.getInstance().haveCacheLarger(list.get(position).getLarge_image().getUrl_list().get(0).getUrl(), one.iv, context);
        return convertView;
    }

    static class ViewHolderOne {
        ImageView iv;
        TextView tv;
        TextView commentNum;
        TextView unPraiseNum;
        TextView praiseNum;
        ImageView praise;
        ImageView unPraise;
        ImageView comment;
        CheckBox shoucang;
        ImageView share;

    }
}