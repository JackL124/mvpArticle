package com.jackl.mvparticle.base.swipeback.listener;

import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import com.jackl.mvparticle.base.swipeback.anim.FragmentAnimator;
import com.jackl.mvparticle.base.swipeback.core.ExtraTransaction;
import com.jackl.mvparticle.base.swipeback.core.SupportFragmentDelegate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * -----------------------------------------------------------------
 * Copyright (C) 2018-2019, by jackl, All rights reserved.
 * -----------------------------------------------------------------
 *                      _ooOoo_
 *                     o8888888o
 *                     88" . "88
 *                     (| -_- |)
 *                      O\ = /O
 *                  ____/`---'\____
 *                .   ' \\| |// `.
 *                 / \\||| : |||// \
 *               / _||||| -:- |||||- \
 *                 | | \\\ - /// | |
 *              | \_| ''\---/'' | |
 *                \ .-\__ `-` ___/-. /
 *             ___`. .' /--.--\ `. . __
 *          ."" '< `.___\_<|>_/___.' >'"".
 *         | | : `- \`.;`\ _ /`;.`/ - ` : | |
 *           \ \ `-. \_ __\ /__ _/ .-` / /
 *   ======`-.____`-.___\_____/___.-`____.-'======
 *                      `=---='
 *   .............................................
 *            佛祖保佑             永无BUG
 * @Author: JackL
 * 创建时间: 2019/2/20 8:46
 * 版本:1.0.0
 * 描述: IBaseSupportFragment
 *
*/

public interface ISupportFragment {
      // LaunchMode
      int STANDARD = 0;
      int SINGLETOP = 1;
      int SINGLETASK = 2;

      // ResultCode
      int RESULT_CANCELED = 0;
      int RESULT_OK = -1;

      @IntDef({STANDARD, SINGLETOP, SINGLETASK})
      @Retention(RetentionPolicy.SOURCE)
      public @interface LaunchMode {
      }

      SupportFragmentDelegate getSupportDelegate();

      ExtraTransaction extraTransaction();

      void enqueueAction(Runnable runnable);

      void post(Runnable runnable);

      void onEnterAnimationEnd(@Nullable Bundle savedInstanceState);

      void onLazyInitView(@Nullable Bundle savedInstanceState);

      void onSupportVisible();

      void onSupportInvisible();

      boolean isSupportVisible();

      FragmentAnimator onCreateFragmentAnimator();

      FragmentAnimator getFragmentAnimator();

      void setFragmentAnimator(FragmentAnimator fragmentAnimator);

      void setFragmentResult(int resultCode, Bundle bundle);

      void onFragmentResult(int requestCode, int resultCode, Bundle data);

      void onNewBundle(Bundle args);

      void putNewBundle(Bundle newBundle);

      boolean onBackPressedSupport();
}

