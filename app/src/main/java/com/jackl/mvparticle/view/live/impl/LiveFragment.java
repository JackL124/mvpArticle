package com.jackl.mvparticle.view.live.impl;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.jackl.mvparticle.R;
import com.jackl.mvparticle.adapter.FragmentAdapter;
import com.jackl.mvparticle.base.baseview.BaseLoadFragment;
import com.jackl.mvparticle.utils.ScreenUtils;
import com.jackl.mvparticle.view.live.impl.LiveListFragment;
import com.jackl.mvparticle.widget.ScaleTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import java.util.ArrayList;
import java.util.List;
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
 * 创建时间: 2019/3/13 10:40
 * 版本:1.0.0
 * 描述: LiveFragment
 *
*/

public class LiveFragment extends BaseLoadFragment {

      @BindView(R.id.magic_indicator)
      MagicIndicator tabLayout;

      @BindView(R.id.viewpager)
      ViewPager viewPager;

      private List<String> titles;
      private List<Fragment> mFragments;
      private FragmentAdapter fragmentAdapter;

      @Override
      protected int getContentView() {
            return R.layout.fragment_lives;
      }

      @Override
      protected void initInjector() {

      }

      @Override
      protected void initView() {
            setSwipeBackEnable(false);
            initPagerTitle();
            initViewPager();
            initMagicIndicator();
      }

      private void initMagicIndicator() {
            tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            CommonNavigator commonNavigator = new CommonNavigator(mContext);
            commonNavigator.setFollowTouch(true);
            commonNavigator.setAdapter(new CommonNavigatorAdapter() {

                  @Override
                  public int getCount() {
                        return titles == null ? 0 : titles.size();
                  }

                  @Override
                  public IPagerTitleView getTitleView(Context context, final int index) {
                        ScaleTransitionPagerTitleView simplePagerTitleView = new ScaleTransitionPagerTitleView(context);
                        simplePagerTitleView.setText(titles.get(index));
                        simplePagerTitleView.setTextSize(18);
                        simplePagerTitleView.setNormalColor(getResources().getColor(R.color.colorDarkWhite));
                        simplePagerTitleView.setSelectedColor(getResources().getColor(R.color.colorWhite));
                        simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                              @Override
                              public void onClick(View v) {
                                    viewPager.setCurrentItem(index);
                              }
                        });
                        return simplePagerTitleView;
                  }

                  @Override
                  public IPagerIndicator getIndicator(Context context) {
                        LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
                        linePagerIndicator.setColors(getResources().getColor(R.color.colorAccent));//线的颜色
                        linePagerIndicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                        linePagerIndicator.setLineHeight(ScreenUtils.dip2px(getAppComponent().getContext(), 3));
                        linePagerIndicator.setLineWidth(ScreenUtils.dip2px(getAppComponent().getContext(), 25));
                        linePagerIndicator.setRoundRadius(ScreenUtils.dip2px(getAppComponent().getContext(), 3));
                        linePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
                        linePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
                        return linePagerIndicator;
                  }
            });
            tabLayout.setNavigator(commonNavigator);
            viewPager.setOffscreenPageLimit(5);
            ViewPagerHelper.bind(tabLayout, viewPager);
      }

      private void initPagerTitle() {
            titles = new ArrayList<>();
            titles.add("守望先锋");
            titles.add("DOTA2");
            titles.add("炉石传说");
            titles.add("CSGO");
            titles.add("英雄联盟");
      }

      private void initViewPager() {
            mFragments = new ArrayList<>();

            mFragments.add(LiveListFragment.newInstance("ow"));
            mFragments.add(LiveListFragment.newInstance("dota2"));
            mFragments.add(LiveListFragment.newInstance("hs"));
            mFragments.add(LiveListFragment.newInstance("csgo"));
            mFragments.add(LiveListFragment.newInstance("lol"));

            fragmentAdapter = new FragmentAdapter(this.getChildFragmentManager(), mFragments);
            viewPager.setAdapter(fragmentAdapter);
      }

}
