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
 * Date: 2015-06-11
 * Time: 15:10
 */
public class Demo3 extends AppCompatActivity{

    private List<String> mItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo3);

        for (int i = 0; i < 50; i++) {
            mItems.add(String.valueOf("item " + i));
        }

        initToolbar();
        initRecyclerView();
        initCollapsingToolbarLayout();
    }

    private void initCollapsingToolbarLayout() {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        collapsingToolbarLayout.setTitle("cheese");
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new MyRecyclerAdapter());
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private View mView;
        private TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mTextView = (TextView) mView.findViewById(R.id.txt_item);
        }

        public void bindData(int position){
            mTextView.setText(mItems.get(position));
        }
    }

    class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(Demo3.this).inflate(R.layout.recycler_item, null);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.bindData(position);
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("demo2");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.abc_ic_menu_cut_mtrl_alpha);
    }
}
