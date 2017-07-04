package com.zj.example.zj_collapsingtoolbarlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by zhengjiong
 * date: 2017/7/4 22:17
 */

public class Demo14 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo14);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbarlayout);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float ratio = 1f * Math.abs(verticalOffset) / appBarLayout.getTotalScrollRange();
                System.out.println("totalScrollRange=" + appBarLayout.getTotalScrollRange()
                        + " ,verticalOffset=" + Math.abs(verticalOffset) + " ,ratio=" + ratio);
                toolbar.setAlpha(ratio);
            }
        });
    }
}
