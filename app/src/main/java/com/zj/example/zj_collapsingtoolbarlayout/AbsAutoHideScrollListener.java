package com.zj.example.zj_collapsingtoolbarlayout;

import android.support.v7.widget.RecyclerView;

/**
 * Title: AbsAutoHideScrollListener
 * Description:
 * Copyright:Copyright(c)2016
 * Company: 博智维讯信息技术有限公司
 * CreateTime:17/5/23  14:01
 *
 * @author 郑炯
 * @version 1.0
 */
public abstract class AbsAutoHideScrollListener extends RecyclerView.OnScrollListener {

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
