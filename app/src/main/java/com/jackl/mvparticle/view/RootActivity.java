package com.jackl.mvparticle.view;

import com.jackl.mvparticle.R;
import com.jackl.mvparticle.base.MyApplication;
import com.jackl.mvparticle.base.baseview.BaseStatusActivity;
import com.jackl.mvparticle.base.baseview.BaseSwipeBackFragment;
import com.jackl.mvparticle.view.example.ExampleFragment;
import com.jackl.mvparticle.view.live.impl.LiveFragment;
import com.jackl.mvparticle.widget.BottomBar;
import com.jackl.mvparticle.widget.BottomBarTab;
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
 * 创建时间: 2019/1/22 9:38
 * 版本:1.0.0
 * 描述: RootActivity
 *
*/

public class RootActivity extends BaseStatusActivity  {
     @BindView(R.id.bottomBar)
     BottomBar mBottomBar;
      private BaseSwipeBackFragment[] mFragments = new BaseSwipeBackFragment[2];
      @Override
      protected int getContentView() {
            return R.layout.activity_root;
      }

      @Override
      protected void initInjector() {

      }

      @Override
      protected void initView() {
            setSwipeBackEnable(false);
            mFragments[0] = new ExampleFragment();
            mFragments[1] =new LiveFragment();

            loadMultipleRootFragment(R.id.tab_container, 0, mFragments[0], mFragments[1]);

            mBottomBar.addItem(new BottomBarTab(MyApplication.getAppContext(), R.mipmap.tab_example, getString(R.string.examples)))
                      .addItem(new BottomBarTab(MyApplication.getAppContext(), R.mipmap.tab_lives, getString(R.string.lives)));

            mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
                  @Override
                  public void onTabSelected(int position, int prePosition) {
                        showHideFragment(mFragments[position], mFragments[prePosition]);
                  }

                  @Override
                  public void onTabUnselected(int position) {

                  }

                  @Override
                  public void onTabReselected(int position) {
                        // 在FirstPagerFragment,FirstHomeFragment中接收, 因为是嵌套的Fragment
                        // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
                  }
            });

      }
}
