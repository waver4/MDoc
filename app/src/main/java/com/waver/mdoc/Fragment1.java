package com.waver.mdoc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Fragment1 extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<Cardnews> cardnewses;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initdataset();

    }

    //添加新闻
    private void initdataset() {
        cardnewses = new ArrayList<>();
        cardnewses.add(new Cardnews(getString(R.string.news_one_title), getString(R.string.news_one_title), R.mipmap.ic_launcher));
        cardnewses.add(new Cardnews(getString(R.string.news_one_title), getString(R.string.news_one_title), R.mipmap.ic_launcher));
        cardnewses.add(new Cardnews(getString(R.string.news_one_title), getString(R.string.news_one_title), R.mipmap.ic_launcher));
        cardnewses.add(new Cardnews(getString(R.string.news_one_title), getString(R.string.news_one_title), R.mipmap.ic_launcher));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        final FragmentActivity c = getActivity();
        //Fragment+RecyclerView+CardView组合使用
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(c, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        new Thread(new Runnable() {
            @Override
            public void run() {
                recyclerViewAdapter = new RecyclerViewAdapter(cardnewses, c);
                c.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(recyclerViewAdapter);
                    }
                });
            }
        }).start();
        return view;
    }

}
