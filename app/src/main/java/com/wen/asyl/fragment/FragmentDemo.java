package com.wen.asyl.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.wen.asyl.adapter.AdapterVideoList;
import com.wen.asyl.common.VideoConstant;
import com.wen.asyl.jiecaovideoplayerdemo.R;

import cn.jzvd.Jzvd;

public class FragmentDemo extends Fragment {

    ListView listView;
    int index;

    public FragmentDemo setIndex(int index) {
        this.index = index;
        return this;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInastanceState) {
        listView = (ListView) inflater.inflate(R.layout.layout_list, container, false);
        listView.setAdapter(new AdapterVideoList(getActivity(),
                VideoConstant.videoUrls[index],
                VideoConstant.videoTitles[index],
                VideoConstant.videoThumbs[index]));
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Jzvd.onScrollReleaseAllVideos(view, firstVisibleItem, visibleItemCount, totalItemCount);
            }
        });
        return listView;
    }
}
