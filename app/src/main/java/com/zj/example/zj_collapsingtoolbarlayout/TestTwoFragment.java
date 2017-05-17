package com.zj.example.zj_collapsingtoolbarlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: TestFragment
 * Description:
 * Copyright:Copyright(c)2016
 * Company: 博智维讯信息技术有限公司
 * CreateTime:17/5/15  14:44
 *
 * @author 郑炯
 * @version 1.0
 */
public class TestTwoFragment extends Fragment {
    private List<String> mItems = new ArrayList<>();
    private RecyclerView mRecyclerView1;
    public RecyclerView mRecyclerView2;
    public View headerView;

    public static TestTwoFragment newInstance() {

        Bundle args = new Bundle();

        TestTwoFragment fragment = new TestTwoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_two_layout, container, false);
        mRecyclerView1 = (RecyclerView) view.findViewById(R.id.recyclerview1);
        mRecyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerview2);
        headerView = view.findViewById(R.id.header);

        for (int i = 0; i < 30; i++) {
            mItems.add(String.valueOf(i));
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView1.setAdapter(new MyRecyclerViewAdapter());

        mRecyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView2.setAdapter(new MyRecyclerViewAdapter());

        /*mRecyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                System.out.println("onScrolled dy=" + dy);
            }
        });*/
        return view;
    }

    class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.recycler_item, viewGroup, false);
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

    class MyViewHolder extends RecyclerView.ViewHolder {
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
