package com.bw.toutiaonews_demo.fraggments.anyfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bw.toutiaonews_demo.R;
import com.bw.toutiaonews_demo.adapters.NewsListAdapter;
import com.bw.toutiaonews_demo.base.BaseFragment;
import com.bw.toutiaonews_demo.bean.TuijianBean1;
import com.bw.toutiaonews_demo.utils.IAsyncTask;
import com.bw.toutiaonews_demo.utils.ResponseListener;
import com.bw.toutiaonews_demo.utils.Urls;
import com.bwei.springview.container.DefaultFooter;
import com.bwei.springview.container.DefaultHeader;
import com.bwei.springview.widget.SpringView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class TuijianFragment extends BaseFragment implements ResponseListener, SpringView.OnFreshListener {

    private ListView listView;
    private SpringView springView;
    private NewsListAdapter adapter;
    private List<TuijianBean1.DataBean> list = new ArrayList<TuijianBean1.DataBean>();
    //标志 那个页面 1 推荐
    private int type;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getArguments() != null) {
            type = getArguments().getInt("pos");
        }
        View view = View.inflate(getActivity(), R.layout.tuijianfragment, null);
        listView = (ListView) view.findViewById(R.id.listView);

        springView = (SpringView) view.findViewById(R.id.tuijian_springview);
        springView.setType(SpringView.Type.FOLLOW);

        springView.setHeader(new DefaultHeader(getContext()));
        springView.setFooter(new DefaultFooter(getContext()));

        adapter = new NewsListAdapter(getActivity(),list);
        listView.setAdapter(adapter);

        springView.setListener(this);
        getData();
        return view;
    }

    public void getData() {
        IAsyncTask task = new IAsyncTask(this);

        String path = "";
        if (type == 0) {
            path = Urls.tuijian;
        }
        task.iExecuteOnExecutor(task, path);
    }

    //请求数据 结果
    @Override
    public void onSuccess(String string) {

        Gson gson = new Gson();

        TuijianBean1 bean = gson.fromJson(string, TuijianBean1.class);

        list.addAll(bean.getData());
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onFail() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadmore() {

    }
}