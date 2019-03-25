
package com.jackl.mvparticle.base.baseview;

import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.jackl.mvparticle.R;
import com.jackl.mvparticle.base.MyApplication;
import com.jackl.mvparticle.base.swipeback.SwipeBackActivityDelegate;
import com.jackl.mvparticle.base.swipeback.listener.ISwipeBackActivity;
import com.jackl.mvparticle.base.swipeback.widget.SwipeBackLayout;
import com.jackl.mvparticle.inject.component.ActivityComponent;
import com.jackl.mvparticle.inject.component.AppComponent;
import com.jackl.mvparticle.inject.component.DaggerActivityComponent;
import com.jackl.mvparticle.module.ActivityModule;
import butterknife.ButterKnife;
import butterknife.Unbinder;

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
 * 创建时间: 2019/2/20 13:26
 * 版本:1.0.0
 * 描述: SwipeBackActivity
 *
 */

 abstract class BaseSwipeBackActivity extends BaseActivity implements ISwipeBackActivity {

      private Unbinder bind;
      final SwipeBackActivityDelegate mDelegate = new SwipeBackActivityDelegate(this);
      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mDelegate.onCreate(savedInstanceState);
            beforeLayout();
            setContentView(getContentView());
            bind=ButterKnife.bind(this);
            initInjector();
            initView();
      }

      @Override
      protected void onPostCreate(Bundle savedInstanceState) {
            super.onPostCreate(savedInstanceState);
            mDelegate.onPostCreate(savedInstanceState);
      }


      @Override
      protected void onDestroy() {
            super.onDestroy();
            bind.unbind();
      }

      /**
       * 用于在setContentView之前做处理
       */
      protected void beforeLayout() {
      }

      /**
       * 设置layout布局
       */
      protected abstract int getContentView();

      /**
       * Dagger 注入
       */
      protected abstract void initInjector();

      /**
       * 页面初始化工作
       */
      protected abstract void initView();

      @Override
      public SwipeBackLayout getSwipeBackLayout() {
            return mDelegate.getSwipeBackLayout();
      }

      /**
       * 是否可滑动
       *
       * @param enable
       */
      @Override
      public void setSwipeBackEnable(boolean enable) {
            mDelegate.setSwipeBackEnable(enable);
      }

      @Override
      public void setEdgeLevel(SwipeBackLayout.EdgeLevel edgeLevel) {
            mDelegate.setEdgeLevel(edgeLevel);
      }

      public void setParallaxOffset(@FloatRange(from = 0.0f, to = 1.0f) float offset) {
            mDelegate.setParallaxOffset(offset);
      }

      @Override
      public void setEdgeLevel(int widthPixel) {
            mDelegate.setEdgeLevel(widthPixel);
      }

      /**
       * 限制SwipeBack的条件,默认栈内Fragment数 <= 1时 , 优先滑动退出Activity , 而不是Fragment
       *
       * @return true: Activity优先滑动退出;  false: Fragment优先滑动退出
       */
      @Override
      public boolean swipeBackPriority() {
            return mDelegate.swipeBackPriority();
      }

      @Override
      public void onBackPressed() {
            mDelegate.setSwipeBackFiinish(true);
            super.onBackPressed();
      }

      protected ActivityComponent getActivityComponent() {
            return DaggerActivityComponent.builder()
                      .appComponent(getAppComponent())
                      .activityModule(getActivityModule())
                      .build();
      }

      public void initToolBar(Toolbar toolbar, String title) {
            toolbar.setTitle(title);
            toolbar.setNavigationIcon(R.mipmap.ic_back);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                        finish();
                  }
            });

      }

      protected ActivityModule getActivityModule() {
            return new ActivityModule(this);
      }


      protected AppComponent getAppComponent() {
            return MyApplication.getAppComponent();
      }

      protected void gone(final View... views) {
            if (views != null && views.length > 0) {
                  for (View view : views) {
                        if (view != null) {
                              view.setVisibility(View.GONE);
                        }
                  }
            }
      }

      protected void visible(final View... views) {
            if (views != null && views.length > 0) {
                  for (View view : views) {
                        if (view != null) {
                              view.setVisibility(View.VISIBLE);
                        }
                  }
            }
      }
}
