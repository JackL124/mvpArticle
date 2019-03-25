package com.jackl.mvparticle.view.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.jackl.mvparticle.R;
import com.jackl.mvparticle.base.baseview.BaseLoadFragment;
import com.jackl.mvparticle.view.example.example_five.impl.ExampleFiveActivity;
import com.jackl.mvparticle.view.example.example_four.impl.ExampleFourActivity;
import com.jackl.mvparticle.view.example.example_one.ExampleOneActivity;
import com.jackl.mvparticle.view.example.example_three.impl.ExampleThreeActivity;
import com.jackl.mvparticle.view.example.example_two.ExampleTwoActivity;
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
 * 创建时间: 2019/1/23 10:05
 * 版本:1.0.0
 * 描述: ExampleFragment
 *
*/

public class ExampleFragment extends BaseLoadFragment {
      @BindView(R.id.toolbar)
      Toolbar toolbar;
      @BindView(R.id.iv_appbar)
      ImageView iv_appbar;

      @Override
      protected int getContentView() {
            return R.layout.fragment_example;
      }

      @Override
      protected void initInjector() {

      }

      @Override
      protected void initView() {
            setSwipeBackEnable(false);
            toolbar.setTitle("案例演示");
            ((AppCompatActivity)_mActivity).setSupportActionBar(toolbar);
            Glide.with(this).load(R.mipmap.background).into(iv_appbar);
      }

      @OnClick({R.id.example_one,R.id.example_two,R.id.example_three,R.id.example_four,R.id.example_five})
      public void onClick(View view){
            switch (view.getId()){
                  case R.id.example_one:
                        startActivity(new Intent(_mActivity, ExampleOneActivity.class));
                        break;

                  case R.id.example_two:
                        startActivity(new Intent(_mActivity, ExampleTwoActivity.class));
                        break;

                  case R.id.example_three:
                        startActivity(new Intent(_mActivity, ExampleThreeActivity.class));
                        break;

                  case R.id.example_four:
                        startActivity(new Intent(_mActivity, ExampleFourActivity.class));
                        break;

                  case R.id.example_five:
                        startActivity(new Intent(_mActivity, ExampleFiveActivity.class));
                        break;

            }
      }
}
