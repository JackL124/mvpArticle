package com.jackl.mvparticle.base.swipeback;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;

import com.jackl.mvparticle.base.swipeback.listener.ISupportActivity;
import com.jackl.mvparticle.base.swipeback.listener.ISwipeBackActivity;
import com.jackl.mvparticle.base.swipeback.widget.SwipeBackLayout;

public class SwipeBackActivityDelegate {
      private FragmentActivity mActivity;
      private SwipeBackLayout mSwipeBackLayout;

      public SwipeBackActivityDelegate(ISwipeBackActivity swipeBackActivity) {
            if (!(swipeBackActivity instanceof FragmentActivity) || !(swipeBackActivity instanceof ISupportActivity))
                  throw new RuntimeException("Must extends FragmentActivity/AppCompatActivity and implements ISupportActivity");
            mActivity = (FragmentActivity) swipeBackActivity;
      }

      public void onCreate(Bundle savedInstanceState) {
            onActivityCreate();
      }

      public void onPostCreate(Bundle savedInstanceState) {
            mSwipeBackLayout.attachToActivity(mActivity);
      }

      public SwipeBackLayout getSwipeBackLayout() {
            return mSwipeBackLayout;
      }

      public void setSwipeBackEnable(boolean enable) {
            mSwipeBackLayout.setEnableGesture(enable);
      }

      public void setEdgeLevel(SwipeBackLayout.EdgeLevel edgeLevel) {
            mSwipeBackLayout.setEdgeLevel(edgeLevel);
      }

      public void setEdgeLevel(int widthPixel) {
            mSwipeBackLayout.setEdgeLevel(widthPixel);
      }

      /**
       * 限制SwipeBack的条件,默认栈内Fragment数 <= 1时 , 优先滑动退出Activity , 而不是Fragment
       *
       * @return true: Activity可以滑动退出, 并且总是优先;  false: Fragment优先滑动退出
       */
      public boolean swipeBackPriority() {
            return mActivity.getSupportFragmentManager().getBackStackEntryCount() <= 1;
      }

      public void setParallaxOffset(@FloatRange(from = 0.0f, to = 1.0f) float offset) {
            mSwipeBackLayout.setParallaxOffset(offset);
      }

      public void setSwipeBackFiinish(boolean finish) {
            mSwipeBackLayout.setSwipeBackFiinish(finish);
      }

      private void onActivityCreate() {
            if (mActivity== null) return;
            mActivity.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            mActivity.getWindow().getDecorView().setBackgroundColor(Color.TRANSPARENT);
            mSwipeBackLayout = new SwipeBackLayout(mActivity);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            mSwipeBackLayout.setLayoutParams(params);
      }
}

