package com.jackl.mvparticle.view.example.example_one;

import android.content.Intent;
import com.jackl.mvparticle.R;
import com.jackl.mvparticle.base.baseview.BaseStatusFragment;
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
 * 创建时间: 2019/2/10 11:02
 * 版本:1.0.0
 * 描述: ExampleOneFragment
 *
*/

public class ExampleOneFragment extends BaseStatusFragment {


      @Override
      protected int getContentView() {
            return R.layout.fragment_exampleone;
      }

      @Override
      protected void initInjector() {

      }

      @Override
      protected void initView() {
      }

      @OnClick(R.id.start)
      public void onClick() {
            startActivity(new Intent(getActivity(), ExampleOneOtherActivity.class));
      }
}


