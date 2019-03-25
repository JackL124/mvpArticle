package com.jackl.mvparticle.view.example.example_one;

import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import com.jackl.mvparticle.R;
import com.jackl.mvparticle.base.baseview.BaseLoadActivity;
import com.jackl.mvparticle.base.swipeback.anim.DefaultHorizontalAnimator;
import com.jackl.mvparticle.base.swipeback.anim.FragmentAnimator;
import butterknife.BindView;

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
 * 创建时间: 2019/2/10 10:43
 * 版本:1.0.0
 * 描述: ExampleOneActivity
 *
*/

public class ExampleOneActivity extends BaseLoadActivity {
      @BindView(R.id.toolbar)
      Toolbar mToolbar;

      @BindView(R.id.container)
      FrameLayout container;

      @Override
      protected int getContentView() {
            return R.layout.activity_exampleone;
      }

      @Override
      protected void initInjector() {

      }

      @Override
      protected void beforeLayout() {
            super.beforeLayout();
      }

      @Override
      protected void initView() {
            initToolBar(mToolbar,"案例1");
            loadRootFragment(R.id.container, new ExampleOneFragment());
      }


      @Override
      public void onBackPressedSupport() {
            super.onBackPressedSupport();
      }

      @Override
      public FragmentAnimator onCreateFragmentAnimator() {
            return new DefaultHorizontalAnimator();
      }
}
