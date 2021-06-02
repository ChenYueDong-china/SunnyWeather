package com.heyingguai.sunnyweather;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

public class SampleTitleBehavior extends CoordinatorLayout.Behavior<View> {
    // 列表顶部和title底部重合时，列表的滑动距离。
    private float deltaY;

    public SampleTitleBehavior() {
    }

    public SampleTitleBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof NestedScrollView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        if (deltaY == 0) {
            deltaY = dependency.getY() - child.getHeight();
        }

        float dy = dependency.getY() - child.getHeight();
        //Log.i("TAG", "dy: " + dy);
        //Log.i("TAG", "deltaY: " + deltaY);
        dy = dy < 0 ? 0 : dy;
        float alpha = 1 - (dy / deltaY);
        alpha = alpha < 0 ? 0 : alpha;
        //Log.i("TAG", "alpha: " + alpha);
        Log.i("TAG", "alpha: " + (int) (alpha * 255));

        child.getBackground().setAlpha((int) (alpha * 255));

        return true;

    }
}
