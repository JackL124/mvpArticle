package com.jackl.mvparticle.base.swipeback.listener;

import android.view.MotionEvent;
import com.jackl.mvparticle.base.swipeback.anim.FragmentAnimator;
import com.jackl.mvparticle.base.swipeback.core.ExtraTransaction;
import com.jackl.mvparticle.base.swipeback.core.SupportActivityDelegate;

public interface ISupportActivity {
      SupportActivityDelegate getSupportDelegate();

      ExtraTransaction extraTransaction();

      FragmentAnimator getFragmentAnimator();

      void setFragmentAnimator(FragmentAnimator fragmentAnimator);

      FragmentAnimator onCreateFragmentAnimator();

      void post(Runnable runnable);

      void onBackPressed();

      void onBackPressedSupport();

      boolean dispatchTouchEvent(MotionEvent ev);
}
