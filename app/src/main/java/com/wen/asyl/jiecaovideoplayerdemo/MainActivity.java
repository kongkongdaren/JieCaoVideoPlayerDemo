package com.wen.asyl.jiecaovideoplayerdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.bumptech.glide.Glide;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private JzvdStd mVideoplayer;
    private Button mBtnListView;
    private Button mBtnViewpagerListView;
    private Button mBtnSortListView;
    private Button mBtnRecyclerview;
    private Button mBtnSmallWindow;
    private Button mBtnWebView;
    private Button mBtnUI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVideoplayer = (JzvdStd) findViewById(R.id.videoplayer);
        mVideoplayer.setUp("http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4"
                , "饺子快长大" , Jzvd.SCREEN_WINDOW_NORMAL);
        Glide.with(this).load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png").into(mVideoplayer.thumbImageView);
        mBtnListView = (Button) findViewById(R.id.btn_listView);
        mBtnViewpagerListView = (Button) findViewById(R.id.btn_viewpager_listView);
        mBtnSortListView = (Button) findViewById(R.id.btn_sort_listView);
        mBtnRecyclerview = (Button) findViewById(R.id.btn_recyclerview);
        mBtnSmallWindow = (Button) findViewById(R.id.btn_small_window);
        mBtnUI = (Button) findViewById(R.id.btn_UI);
        mBtnWebView = (Button) findViewById(R.id.btn_webView);
        mBtnListView.setOnClickListener(this);
        mBtnViewpagerListView.setOnClickListener(this);
        mBtnSortListView.setOnClickListener(this);
        mBtnSmallWindow.setOnClickListener(this);
        mBtnRecyclerview.setOnClickListener(this);
        mBtnUI.setOnClickListener(this);
        mBtnWebView.setOnClickListener(this);

    }
    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_listView:
                startActivity(new Intent(MainActivity.this, ActivityListViewNormal.class));
                break;
            case R.id.btn_viewpager_listView:
                startActivity(new Intent(MainActivity.this, ActivityListViewFragmentViewPager.class));
                break;
            case R.id.btn_sort_listView:
                startActivity(new Intent(MainActivity.this, ActivityListViewMultiHolder.class));
                break;
            case R.id.btn_recyclerview:
                startActivity(new Intent(MainActivity.this, ActivityListViewRecyclerView.class));
                break;
            case R.id.btn_small_window:
                startActivity(new Intent(MainActivity.this, SmallWindowActivity.class));
                break;
            case R.id.btn_UI:
                startActivity(new Intent(MainActivity.this, UIActivity.class));
                break;
            case R.id.btn_webView:
                startActivity(new Intent(MainActivity.this, ActivityWebView.class));
                break;

        }
    }
}
