package com.jackl.mvparticle.widget;

import android.content.Context;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

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
 * 创建时间: 2019/1/22 11:00
 * 版本:1.0.0
 * 描述: ScaleTransitionPagerTitleView
 *
*/

public class ScaleTransitionPagerTitleView extends ColorTransitionPagerTitleView {

      private float mMinScale = 0.80f;

      public ScaleTransitionPagerTitleView(Context context) {
            super(context);
      }

      @Override
      public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {
            super.onEnter(index, totalCount, enterPercent, leftToRight);    // 实现颜色渐变
            setScaleX(mMinScale + (1.0f - mMinScale) * enterPercent);
            setScaleY(mMinScale + (1.0f - mMinScale) * enterPercent);
      }

      @Override
      public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {
            super.onLeave(index, totalCount, leavePercent, leftToRight);    // 实现颜色渐变
            setScaleX(1.0f + (mMinScale - 1.0f) * leavePercent);
            setScaleY(1.0f + (mMinScale - 1.0f) * leavePercent);
      }

      public float getMinScale() {
            return mMinScale;
      }

      public void setMinScale(float minScale) {
            mMinScale = minScale;
      }

}
