package com.zj.example.zj_collapsingtoolbarlayout;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
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

/**
 * create by zhengjiong
 * Date: 2015-06-10
 * Time: 17:54
 */
public class Demo1 extends AppCompatActivity{

    private List<String> mItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo1);

        for (int i = 0; i < 20; i++) {
            mItems.add(String.valueOf(i));
        }

        initToolbar();
        initRecyclerView();
        initCollapsingToolbar();
    }

    private void initCollapsingToolbar() {
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        collapsingToolbar.setTitle("cheese");

        collapsingToolbar.setOverScrollMode(View.OVER_SCROLL_IF_CONTENT_SCROLLS);
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyRecyclerViewAdapter());

    }

    class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(Demo1.this).inflate(R.layout.recycler_item, viewGroup, false);
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

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.abc_ic_menu_cut_mtrl_alpha);
    }
}
