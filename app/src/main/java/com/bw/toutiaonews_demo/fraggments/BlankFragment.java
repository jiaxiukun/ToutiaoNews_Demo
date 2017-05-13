package com.bw.toutiaonews_demo.fraggments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bw.toutiaonews_demo.R;
import com.bw.toutiaonews_demo.adapters.BlankAdapter;
import com.bw.toutiaonews_demo.adapters.DuanZiAdapter;
import com.bw.toutiaonews_demo.adapters.Type1Adapter;
import com.bw.toutiaonews_demo.adapters.Type3Adapter;
import com.bw.toutiaonews_demo.bean.PhotoBook;
import com.bw.toutiaonews_demo.bean.PhotoBookType1;
import com.bw.toutiaonews_demo.bean.PhotoBookType3;
import com.bw.toutiaonews_demo.fraggments.events.BlankEvent;
import com.bw.toutiaonews_demo.network.HttpUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.List;

/**
 * date:2017/5/12
 * author:徐帅(acer)
 * funcation:
 */

public class BlankFragment extends Fragment {
    private View view;

    public BlankFragment() {
    }

    public static BlankFragment newInstance(String api, int type) {
        Bundle bundle = new Bundle();
        bundle.putString("api", api);
        bundle.putInt("type", type);
        BlankFragment blankFragment = new BlankFragment();
        blankFragment.setArguments(bundle);
        return blankFragment;
    }


    private ListView listView;
    //  private List<PhotoBook.DataBean> list=new ArrayList<>();
//  //  private SpringView springView;
//    private NewsAdapter adapter ;
//

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.blank_fragment, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setSelector(new ColorDrawable());
        if (getArguments().getInt("type") == 4) {
            HttpUtils.getAsyn(getArguments().getString("api"), null, PhotoBook.class, new HttpUtils.HttpCallBack<PhotoBook>() {


                @Override
                public void onSuccess(PhotoBook photoBook) {
                    Log.d("BlankFragment4", "成功");

                    List<PhotoBook.DataBean> data = photoBook.getData();
                    BlankAdapter adapter = new BlankAdapter(data, getActivity());
                    listView.setAdapter(adapter);
//                list.addAll(data);
//                adapter.notifyDataSetChanged();


                }

                @Override
                public void onFailure(IOException e) {
                    Log.d("BlankFragment4", "失败");
                }
            });
        } else if (getArguments().getInt("type") == 3) {
            if (getArguments().getString("api").contains("essay_joke")) {
                HttpUtils.getAsyn(getArguments().getString("api"), null, PhotoBookType3.class, new HttpUtils.HttpCallBack<PhotoBookType3>() {


                    @Override
                    public void onSuccess(PhotoBookType3 photoBook) {
                        Log.d("BlankFragment3", "成功");

                        List<PhotoBookType3.DataBean> data = photoBook.getData();
                        DuanZiAdapter adapter = new DuanZiAdapter(data, getActivity());
                        listView.setAdapter(adapter);

                    }

                    @Override
                    public void onFailure(IOException e) {
                        Log.d("BlankFragment3", "失败");
                    }
                });
            } else {
                HttpUtils.getAsyn(getArguments().getString("api"), null, PhotoBookType3.class, new HttpUtils.HttpCallBack<PhotoBookType3>() {


                    @Override
                    public void onSuccess(PhotoBookType3 photoBook) {
                        Log.d("BlankFragment3", "成功");

                        List<PhotoBookType3.DataBean> data = photoBook.getData();
                        Type3Adapter adapter = new Type3Adapter(data, getActivity());
                        listView.setAdapter(adapter);

                    }

                    @Override
                    public void onFailure(IOException e) {
                        Log.d("BlankFragment3", "失败");
                    }
                });
            }
        } else if (getArguments().getInt("type") == 1) {

            HttpUtils.getAsyn(getArguments().getString("api"), null, PhotoBookType1.class, new HttpUtils.HttpCallBack<PhotoBookType1>() {


                @Override
                public void onSuccess(PhotoBookType1 photoBook) {
                    Log.d("BlankFragment1", "成功");

                    List<PhotoBookType1.DataBean> data = photoBook.getData();
                    Type1Adapter adapter = new Type1Adapter(data, getActivity());
                    listView.setAdapter(adapter);

                }

                @Override
                public void onFailure(IOException e) {
                    Log.d("BlankFragment1", "失败");
                }
            });

        }

    }

    public void setMode(boolean white) {
        if (!white) {
            view.setBackgroundColor(getResources().getColor(R.color.nignt_middle));
        } else {
            view.setBackgroundColor(Color.WHITE);

        }
    }

    // 日 夜切换
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMainActivityEvent(BlankEvent event) {
        System.out.println("isChecked = " + event.isWhite());

        if (event.isWhite()) {
            view.setBackgroundColor(Color.WHITE);

        } else {
            view.setBackgroundColor(getResources().getColor(R.color.night_up));
        }
    }

    private void initView(View view) {
        listView = (ListView) view.findViewById(R.id.blank_lv);
        EventBus.getDefault().register(this);
//        springView = (SpringView) view.findViewById(R.id.tuijian_springview);
//
//        springView.setHeader(new DefaultHeader(getContext()));
//        springView.setFooter(new DefaultFooter(getContext()));
//
//        adapter = new NewsAdapter(getActivity(),list);
//        listView.setAdapter(adapter);
//
//        springView.setListener(this);
//
//
//        getData();
    }
//
//
//
//    private void getData(){
//
//        IAsyncTask task =  new IAsyncTask(this) ;
//
//        String path = "" ;
//        if(type == 0){
//            path = Urls.tuijian ;
//        }
//        task.iExecuteOnExecutor(task,path);
//    }

    //    //上啦 下啦
//    @Override
//    public void onRefresh() {
//
//
//    }
//
//    @Override
//    public void onLoadmore() {
//
//
//    }
//
//
//    //请求数据 结果
//    @Override
//    public void onSuccess(String string) {
//
//
////        Gson gson = new Gson();
////        TuijianBean bean = gson.fromJson(string, TuijianBean.class);
////
////        list.addAll(bean.getData());
////        adapter.notifyDataSetChanged();
//
//    }
//
//    @Override
//    public void onFail() {
//
//    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}