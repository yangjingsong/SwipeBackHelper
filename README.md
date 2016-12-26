# SwipeBackHelper
####修改自https://github.com/Jude95/SwipeBackHelper
####添加类似iOS，打开和关闭Activity时底层的Activity也有跟随的动画效果

* 按下返回键时
```Java
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
```
    
* startActivity时
```Java
public void startActivityWithAnimation() {
        if (Build.VERSION.SDK_INT > 11) {
            SwipeBackPage page = SwipeBackHelper.getCurrentPage(this);
            if (page != null) {
                new PageTimeCounter(500, 1, page, false).start();
            }
        }
    }
```
