package com.zj.example.zj_collapsingtoolbarlayout;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Title: Utils
 * Description:
 * Copyright:Copyright(c)2016
 * Company: 博智维讯信息技术有限公司
 * CreateTime:17/5/15  14:34
 *
 * @author 郑炯
 * @version 1.0
 */
public class Utils {

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
