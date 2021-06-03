package com.heyingguai.sunnyweather.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.WindowInsets;

import androidx.drawerlayout.widget.DrawerLayout;

public class WindowInsertFrameLayout extends DrawerLayout {

    public WindowInsertFrameLayout(Context context) {
        this(context, null);
    }

    public WindowInsertFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
   /*
      //没有必要一直请求重新分发，一次就好，刷新
           setOnHierarchyChangeListener(new OnHierarchyChangeListener() {
            @Override
            public void onChildViewAdded(View parent, View child) {
                //当有child添加时，请求再次分发一次WindowInsets
                requestApplyInsets();
            }

            @Override
            public void onChildViewRemoved(View parent, View child) {

            }
        });*/
    }

    @Override
    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        //重写分发方法，不判断是否消费
        for (int index = 0; index < getChildCount(); index++) {
            getChildAt(index).dispatchApplyWindowInsets(insets);
        }
        return insets;
    }
}
