package com.wen.asyl.jiecaovideoplayerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;


public class SmallWindowActivity extends AppCompatActivity  implements View.OnClickListener{

    private Button btnSmallListView;
    private Button btnSmallSortListView;
    private Button btnSmallRecyclerview;
    private Button btnSmallSortRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small);
        btnSmallListView = (Button) findViewById(R.id.btn_small_listView);
        btnSmallSortListView = (Button) findViewById(R.id.btn_small_sort_listView);
        btnSmallRecyclerview = (Button) findViewById(R.id.btn_small_recyclerview);
        btnSmallSortRecyclerview = (Button) findViewById(R.id.btn_small_sort_recyclerview);
        btnSmallListView.setOnClickListener(this);
        btnSmallSortListView.setOnClickListener(this);
        btnSmallRecyclerview.setOnClickListener(this);
        btnSmallSortRecyclerview.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_small_listView:
                startActivity(new Intent(SmallWindowActivity.this, ActivityTinyWindowListViewNormal.class));
                break;
            case R.id.btn_small_sort_listView:
                startActivity(new Intent(SmallWindowActivity.this, ActivityTinyWindowListViewMultiHolder.class));
                break;
            case R.id.btn_small_recyclerview:
                startActivity(new Intent(SmallWindowActivity.this, ActivityTinyWindowRecycleView.class));
                break;
            case R.id.btn_small_sort_recyclerview:
                startActivity(new Intent(SmallWindowActivity.this, ActivityTinyWindowRecycleViewMultiHolder.class));
                break;


        }
    }
}
