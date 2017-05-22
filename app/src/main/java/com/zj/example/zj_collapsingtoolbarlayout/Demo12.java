package com.zj.example.zj_collapsingtoolbarlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Title: Demo8
 * Description:
 * Copyright:Copyright(c)2016
 * Company: 博智维讯信息技术有限公司
 * CreateTime:17/5/15  13:54
 *
 * @author 郑炯
 * @version 1.0
 */
public class Demo12 extends AppCompatActivity {
    private int max;
    private int toolbarContentTotalTranslationY;
    private int leftTotalDistance;
    private int actionbarSize;
    private int editInitLeftMargin;

    private AppBarLayout mAppBarLayout;
    private CircleImageView mAvatarImageView;
    private TextView mTitleTextView;
    private Toolbar mToolBar;

    private RecyclerView mRecyclerView;
    private View searchView;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private View mToolbarContent;
    private TestTwoFragment currentFragment;
    private List<Fragment> fragments;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo11);

        mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        mAvatarImageView = (CircleImageView) findViewById(R.id.imageView_avatar);
        mTitleTextView = (TextView) findViewById(R.id.textView_title);
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.edit_search);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mToolbarContent = findViewById(R.id.toolbar_child_container);

        toolbarContentTotalTranslationY = Utils.dip2px(this, 12);
        max = Utils.dip2px(Demo12.this, 46);//editText最大可滑动的距离

        actionbarSize = Utils.dip2px(Demo12.this, 56);
        editInitLeftMargin = Utils.dip2px(Demo12.this, 20);
        leftTotalDistance = actionbarSize - editInitLeftMargin;

        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                verticalOffset = Math.abs(verticalOffset);
                if (verticalOffset > max) {
                    verticalOffset = max;
                }
                double percent = verticalOffset * 1.0 / max;//editText滑动的进度,1表示已到顶

                if (percent > 1) {
                    percent = 1;
                }
                mToolbarContent.setAlpha((float) (1 - percent));
                mToolbarContent.setTranslationY((float) (-1 * toolbarContentTotalTranslationY * percent));



               /* System.out.println("onOffsetChanged verticalOffset =" + verticalOffset + " ,total=" + appBarLayout.getTotalScrollRange()
                        + " ,percent=" + percent);*/
                //searchView.setTranslationY(-verticalOffset);


                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) searchView.getLayoutParams();
                layoutParams.topMargin = actionbarSize - (int) (percent * max);
                layoutParams.leftMargin = editInitLeftMargin + (int) (percent * leftTotalDistance);
                searchView.setLayoutParams(layoutParams);

            }
        });

        fragments = new ArrayList<>();
        List<String> titles = new ArrayList<>();

        fragments.add(TestTwoFragment.newInstance());
        fragments.add(TestTwoFragment.newInstance());
        fragments.add(TestTwoFragment.newInstance());
        fragments.add(TestTwoFragment.newInstance());
        fragments.add(TestTwoFragment.newInstance());

        titles.add("tab1");
        titles.add("tab2");
        titles.add("tab3");
        titles.add("tab4");
        titles.add("tab5");


        mViewPager.setAdapter(new TestFragmentPagerAdapter(getSupportFragmentManager(), titles, fragments));
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(5);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                for (int i = 0; i < fragments.size(); i++) {
                    TestTwoFragment fragment = (TestTwoFragment) fragments.get(i);
                    if (i == position) {
                        currentFragment = fragment;

                        currentFragment.mRecyclerView2.setOnScrollListener(new AutoHideScrollListener() {
                            @Override
                            public void onHide() {
                                currentFragment.headerView
                                        .animate()
                                        .translationY(-currentFragment.headerView.getHeight())
                                        .setInterpolator(new AccelerateInterpolator(2));
                            }

                            @Override
                            public void onShow() {
                                currentFragment.headerView.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
                            }
                        });
                    } else {
                        fragment.mRecyclerView2.setOnScrollListener(null);
                    }

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            mViewPager.setCurrentItem(1);
            mViewPager.setCurrentItem(0);
        }
    }

    abstract class AutoHideScrollListener extends RecyclerView.OnScrollListener {
        private static final int HIDE_THRESHOLD = 20;
        private int scrolledDistance = 0;
        private boolean isVisible = true;

        public abstract void onHide();

        public abstract void onShow();

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            if ((isVisible && dy > 0) || (!isVisible && dy < 0)) {
                scrolledDistance += Math.abs(dy);
            }

            if (scrolledDistance > HIDE_THRESHOLD && isVisible) {
                onHide();
                isVisible = false;
                scrolledDistance = 0;
            } else if (scrolledDistance > HIDE_THRESHOLD && !isVisible) {
                onShow();
                isVisible = true;
                scrolledDistance = 0;
            }
        }
    }
}
