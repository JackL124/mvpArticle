package com.jackl.mvparticle.view.live.impl;

import android.view.View;
import com.jackl.mvparticle.R;
import com.jackl.mvparticle.base.baseview.BaseLoadFragment;
import com.jackl.mvparticle.base.swipeback.anim.DefaultVerticalAnimator;
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
 * 创建时间: 2019/3/16 10:13
 * 版本:1.0.0
 * 描述: CommentInfofragment
 *
*/
public class CommentInfofragment extends BaseLoadFragment {

      @Override
      protected int getContentView() {
            return R.layout.fragment_commentinfo;
      }

      @Override
      protected void initInjector() {

      }

      @Override
      protected void initView() {
            setFragmentAnimator(new DefaultVerticalAnimator());
            setSwipeBackEnable(true);
      }

      @OnClick({R.id.btn_send})
      public void onClick(View view){
            switch (view.getId()){
                  case R.id.btn_send:
                        pop();
                        break;
            }
      }


}
