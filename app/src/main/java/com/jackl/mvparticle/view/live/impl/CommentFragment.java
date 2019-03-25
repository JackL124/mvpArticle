package com.jackl.mvparticle.view.live.impl;

import android.view.View;
import com.jackl.mvparticle.R;
import com.jackl.mvparticle.base.baseview.BaseStatusFragment;
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
 * 创建时间: 2019/3/16 10:19
 * 版本:1.0.0
 * 描述: CommentFragment
 *
*/

public class CommentFragment extends BaseStatusFragment {


      @Override
      protected int getContentView() {
            return R.layout.fragment_comment;
      }

      @Override
      protected void initInjector() {

      }

      @Override
      protected void initView() {
            setSwipeBackEnable(true);

      }

      @OnClick({R.id.comment_tv})
      public void onClick(View view){
            switch (view.getId()){
                  case R.id.comment_tv:
                        CommentInfofragment fragment = new CommentInfofragment();
                        setFragmentAnimator(new DefaultVerticalAnimator());
                        start(fragment);
                        break;
            }
      }


}
