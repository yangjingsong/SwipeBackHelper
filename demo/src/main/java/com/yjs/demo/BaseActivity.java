package com.yjs.demo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yjs.swipbackhelper.PageTimeCounter;
import com.yjs.swipbackhelper.SwipeBackHelper;
import com.yjs.swipbackhelper.SwipeBackPage;

/**
 * Created by Mr.Jude on 2015/9/7.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this)
                .setSwipeBackEnable(true)
                .setSwipeSensitivity(0.5f)
                .setSwipeRelateEnable(true)
                .setSwipeRelateOffset(300);
        //ViewServer.get(this).addWindow(this);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SwipeBackHelper.onDestroy(this);
        //ViewServer.get(this).removeWindow(this);
    }

    public void onResume() {
        super.onResume();
        //ViewServer.get(this).setFocusedWindow(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Build.VERSION.SDK_INT > 11) {
            SwipeBackPage page = SwipeBackHelper.getPrePage(SwipeBackHelper.findHelperByActivity(BaseActivity.this));
            if (page != null) {
                new PageTimeCounter(250, 1, page, true).start();
            }
        }
    }

    public void startActivityWithAnimation() {
        if (Build.VERSION.SDK_INT > 11) {
            SwipeBackPage page = SwipeBackHelper.getCurrentPage(this);
            if (page != null) {
                new PageTimeCounter(500, 1, page, false).start();
            }
        }
    }

}
