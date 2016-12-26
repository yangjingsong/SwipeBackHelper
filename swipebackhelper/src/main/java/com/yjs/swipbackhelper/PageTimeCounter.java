package com.yjs.swipbackhelper;

import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;

/**
 * Created by yangjingsong on 16/12/26.
 */

public class PageTimeCounter extends CountDownTimer {

    private SwipeBackPage page;
    private boolean isBack;

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public PageTimeCounter(long millisInFuture, long countDownInterval, SwipeBackPage page, boolean flag) {
        super(millisInFuture, countDownInterval);
        this.page = page;
        this.isBack = flag;
    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onTick(long millisUntilFinished) {
        if(isBack) {
            float percent = (float) (1 - millisUntilFinished * 0.4 / 100);
            page.getSwipeBackLayout().setX(Math.min(-500 * Math.max(1 - percent, 0) + 40, 0));
        }else {
            float percent = (float) (1 - millisUntilFinished * 0.2 / 100);
            int width = page.getSwipeBackLayout().getWidth();
            page.getSwipeBackLayout().setX(-width * 0.4f * percent);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onFinish() {
        page.getSwipeBackLayout().setX(0);
    }
}
