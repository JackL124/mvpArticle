package com.jackl.mvparticle.view.example.example_four.impl;

import android.support.v7.widget.Toolbar;
import android.view.View;
import com.github.clans.fab.FloatingActionMenu;
import com.jackl.mvparticle.R;
import com.jackl.mvparticle.base.baseview.BaseStatusActivity;
import com.jackl.mvparticle.base.swipeback.anim.DefaultHorizontalAnimator;
import com.jackl.mvparticle.base.swipeback.anim.FragmentAnimator;
import com.jackl.mvparticle.inject.component.example.DaggerExampleFourComponent;
import com.jackl.mvparticle.module.example.ExampleFourModule;
import com.jackl.mvparticle.presenter.example.IExampleFourPresenter;
import com.jackl.mvparticle.view.example.example_four.IExampleFour;
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
 * 创建时间: 2019/3/12 14:05
 * 版本:1.0.0
 * 描述: ExampleFourActivity
 *
*/

public class ExampleFourActivity extends BaseStatusActivity<IExampleFourPresenter> implements IExampleFour {
      @BindView(R.id.toolbar)
      Toolbar mToolbar;
      @BindView(R.id.menu)
      FloatingActionMenu menu;

      @Override
      protected int getContentView() {
            return R.layout.activity_examplefour;
      }

      @Override
      protected void initInjector() {
            DaggerExampleFourComponent
                      .builder()
                      .appComponent(getAppComponent())
                      .exampleFourModule(new ExampleFourModule(this))
                      .build()
                      .inject(this);
      }

      @Override
      protected void beforeLayout() {
            super.beforeLayout();
      }

      @Override
      protected void initView() {
            initToolBar(mToolbar,"案例4");
            mPresenter.getExampleData("content");
            loadStatusLayout.setOnRetryClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                        mPresenter.getExampleData("content");
                  }
            });
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
