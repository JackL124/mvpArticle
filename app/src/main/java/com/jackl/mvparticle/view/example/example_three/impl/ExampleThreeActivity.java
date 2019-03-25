package com.jackl.mvparticle.view.example.example_three.impl;

import android.support.v7.widget.Toolbar;
import android.view.View;
import com.github.clans.fab.FloatingActionMenu;
import com.jackl.mvparticle.R;
import com.jackl.mvparticle.base.baseview.BaseLoadActivity;
import com.jackl.mvparticle.base.swipeback.anim.DefaultHorizontalAnimator;
import com.jackl.mvparticle.base.swipeback.anim.FragmentAnimator;
import com.jackl.mvparticle.inject.component.example.DaggerExampleThreeComponent;
import com.jackl.mvparticle.module.example.ExampleThreeModule;
import com.jackl.mvparticle.presenter.example.IExampleThreePresenter;
import com.jackl.mvparticle.view.example.example_three.IExampleThree;
import butterknife.BindView;
import butterknife.OnClick;

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
 * 创建时间: 2019/2/10 11:50
 * 版本:1.0.0
 * 描述: ExampleThreeActivity
 *
*/

public class ExampleThreeActivity extends BaseLoadActivity<IExampleThreePresenter> implements IExampleThree{
      @BindView(R.id.toolbar)
      Toolbar mToolbar;
      @BindView(R.id.menu)
      FloatingActionMenu menu;

      @Override
      protected int getContentView() {
            return R.layout.activity_examplethree;
      }

      @Override
      protected void initInjector() {
            DaggerExampleThreeComponent
                      .builder()
                      .appComponent(getAppComponent())
                      .exampleThreeModule(new ExampleThreeModule(this))
                      .build().inject(this);
      }

      @Override
      protected void beforeLayout() {
            super.beforeLayout();
      }

      @Override
      protected void initView() {
            initToolBar(mToolbar,"案例3");
            mPresenter.getExampleData("content");
      }

      @Override
      public void onBackPressedSupport() {
            super.onBackPressedSupport();
      }

      @Override
      public FragmentAnimator onCreateFragmentAnimator() {
            return new DefaultHorizontalAnimator();
      }

      @Override
      public void getResultInfo(String status) {

      }

      @OnClick({R.id.fab_loading,R.id.fab_empty,R.id.fab_error,R.id.fab_no_network,R.id.fab_content,})
      public void onClick(View v) {
            switch (v.getId()) {

                  case R.id.fab_empty:
                        mPresenter.getExampleData("empty");
                        break;
                  case R.id.fab_error:
                        mPresenter.getExampleData("data_error");
                        break;
                  case R.id.fab_no_network:
                        mPresenter.getExampleData("network_error");
                        break;

                  case R.id.fab_loading:
                        mPresenter.getExampleData("unknown_error");
                        break;

                  case R.id.fab_content:
                        mPresenter.getExampleData("content");
                        break;
            }
            menu.toggle(false);
      }
}
