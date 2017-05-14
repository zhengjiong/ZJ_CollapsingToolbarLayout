package com.zj.example.zj_collapsingtoolbarlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.Space;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Title: Demo7
 * Description:
 * Copyright:Copyright(c)2016
 * Company: 博智维讯信息技术有限公司
 * CreateTime:17/5/14  18:05
 *
 * @author 郑炯
 * @version 1.0
 */
public class Demo7 extends AppCompatActivity {
    private List<String> mItems = new ArrayList<>();

    private AppBarLayout mAppBarLayout;
    private CircleImageView mAvatarImageView;
    private TextView mToolbarTextView, mTitleTextView;
    private Space mSpace;
    private Toolbar mToolBar;

    private RecyclerView mRecyclerView;
    //private AppBarStateChangeListener mAppBarStateChangeListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo7);

        mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        mAvatarImageView = (CircleImageView) findViewById(R.id.imageView_avatar);
        mToolbarTextView = (TextView) findViewById(R.id.toolbar_title);
        mTitleTextView = (TextView) findViewById(R.id.textView_title);
        mSpace = (Space) findViewById(R.id.space);
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        for (int i = 0; i < 20; i++) {
            mItems.add(String.valueOf(i));
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new MyRecyclerViewAdapter());
    }

    class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(Demo7.this).inflate(R.layout.recycler_item, viewGroup, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
            myViewHolder.bindData(i);
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private View mView;
        private TextView mTxtTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mTxtTitle = (TextView) mView.findViewById(R.id.txt_item);
        }

        public void bindData(int position) {
            mTxtTitle.setText(mItems.get(position));
        }
    }
}
