package com.yjs.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.yjs.swipbackhelper.SwipeBackHelper;
import com.jude.utils.JUtils;

/**
 * 1.ViewPager的冲突处理
// * 2.滑动动画中的二次点击导致动画停止bug
 * 3.false的时候不嵌入SwipeBackLayout
 */
public class MainActivity extends BaseActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fresco.initialize(getApplication());
        JUtils.initialize(getApplication());
        // enable status bar tint
        SwipeBackHelper.getCurrentPage(this)
                .setSwipeBackEnable(false);
        SwipeBackHelper.getCurrentPage(this).setDisallowInterceptTouchEvent(true);
        findViewById(R.id.btn_text).setOnClickListener(this);
        findViewById(R.id.btn_scroll).setOnClickListener(this);
        findViewById(R.id.btn_viewpager).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_text:
                startActivityWithAnimation();
                startActivity(new Intent(this,TextActivity.class));break;
            case R.id.btn_scroll:
                startActivityWithAnimation();
                startActivity(new Intent(this,ListActivity.class));break;
            case R.id.btn_viewpager:
                startActivityWithAnimation();
                startActivity(new Intent(this,ViewPagerActivity.class));break;
        }
    }


}
