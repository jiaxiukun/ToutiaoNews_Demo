package com.bw.toutiaonews_demo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.toutiaonews_demo.R;
import com.bw.toutiaonews_demo.bean.PhotoBook;
import com.bw.toutiaonews_demo.utils.GlideUtils;
import com.bw.toutiaonews_demo.utils.StringUtils;

import java.util.List;

/**
 * description
 * Created by 张芸艳 on 2017/5/10.
 */

public class BlankAdapter extends BaseAdapter {
    private List<PhotoBook.DataBean> list;
    private Context context;
    GlideUtils glideUtils = GlideUtils.getInstance();

    public BlankAdapter(List<PhotoBook.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
//        int type ;
//        try {
//            type = list.get(position).getImage_list().size();
//        } catch (Exception e) {
//            return 2;
//        }
        int type = list.get(position).getImage_list().size();

        if (1 == type) {
            return 0;
        } else if (3 == type) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 3;
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
        ViewHolderOne one = null;
        ViewHolderTwo two = null;
        ViewHolder holder = null;
        int type = getItemViewType(position);
        if (convertView == null) {

            if (type == 1) {


                two = new ViewHolderTwo();
                LayoutInflater inflater = LayoutInflater.from(context);
                convertView = inflater.inflate(R.layout.blank_lv_item_three, null);
                two.author = (TextView) convertView.findViewById(R.id.blank_tv_author);
                two.comment = (TextView) convertView.findViewById(R.id.blank_tv_comment);
                two.date = (TextView) convertView.findViewById(R.id.blank_tv_date);
                two.title = (TextView) convertView.findViewById(R.id.blank_tv_title);
                two.iv1 = (ImageView) convertView.findViewById(R.id.blank_iv_left);
                two.iv2 = (ImageView) convertView.findViewById(R.id.blank_iv_middle);
                two.iv3 = (ImageView) convertView.findViewById(R.id.blank_iv_right);
                two.add = (ImageView) convertView.findViewById(R.id.blank_iv_add);
                convertView.setTag(two);
            } else if (type == 0) {

                one = new ViewHolderOne();
                LayoutInflater inflater = LayoutInflater.from(context);
                convertView = inflater.inflate(R.layout.blank_lv_item_one, null);
                one.author = (TextView) convertView.findViewById(R.id.blank_tv_author1);
                one.comment = (TextView) convertView.findViewById(R.id.blank_tv_comment1);
                one.date = (TextView) convertView.findViewById(R.id.blank_tv_date1);
                one.title = (TextView) convertView.findViewById(R.id.blank_tv_title1);
                one.iv = (ImageView) convertView.findViewById(R.id.blank_iv1);
                one.add = (ImageView) convertView.findViewById(R.id.blank_iv_add1);
                convertView.setTag(one);
            } else if (type == 2) {
                holder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(context);
                convertView = inflater.inflate(R.layout.blank_lv_item, null);
                holder.author = (TextView) convertView.findViewById(R.id.blank_tv_author2);
                holder.comment = (TextView) convertView.findViewById(R.id.blank_tv_comment2);
                holder.date = (TextView) convertView.findViewById(R.id.blank_tv_date2);
                holder.title = (TextView) convertView.findViewById(R.id.blank_tv_title2);
                holder.add = (ImageView) convertView.findViewById(R.id.blank_iv_add2);
                convertView.setTag(holder);
            }
        } else {
            if (type == 1) {

                two = (ViewHolderTwo) convertView.getTag();
            } else if (type == 0) {

                one = (ViewHolderOne) convertView.getTag();

            } else {
                if (type == 2) {
                    holder = (ViewHolder) convertView.getTag();
                }
            }

        }
        if (type == 1) {
            two.title.setText(list.get(position).getTitle());
            two.author.setText(list.get(position).getMedia_name());
            two.date.setText(StringUtils.stampToDate(list.get(position).getPublish_time() + ""));
            two.comment.setText(list.get(position).getComment_count() + "评论");
            if (list.get(position).getImage_list().size() == 3) {
                glideUtils.haveCache(list.get(position).getImage_list().get(0).getUrl(), two.iv1, context);
                glideUtils.haveCache(list.get(position).getImage_list().get(1).getUrl(), two.iv2, context);
                glideUtils.haveCache(list.get(position).getImage_list().get(2).getUrl(), two.iv3, context);
            }


        } else if (type == 0) {
            one.title.setText(list.get(position).getTitle());
            one.author.setText(list.get(position).getMedia_name());
            one.date.setText(StringUtils.stampToDate(list.get(position).getPublish_time() + ""));
            one.comment.setText(list.get(position).getComment_count() + "评论");
            if (list.get(position).getImage_list().size() == 1) {
                glideUtils.haveCache(list.get(position).getMiddle_image().getUrl(), one.iv, context);
            }

        } else if (type == 2) {
            holder.title.setText(list.get(position).getTitle());
            holder.author.setText(list.get(position).getMedia_name());
            holder.date.setText(StringUtils.stampToDate(list.get(position).getPublish_time() + ""));
            holder.comment.setText(list.get(position).getComment_count() + "评论");
        }
        return convertView;
    }

    static class ViewHolderOne {
        TextView title;
        TextView author;
        TextView date;
        TextView comment;
        ImageView add;
        ImageView iv;


    }

    static class ViewHolder {
        TextView title;
        TextView author;
        TextView date;
        TextView comment;
        ImageView add;


    }

    static class ViewHolderTwo {
        TextView title;
        TextView author;
        TextView date;
        TextView comment;
        ImageView add;
        ImageView iv1;
        ImageView iv2;
        ImageView iv3;
    }


}
