package com.jackl.mvparticle.module.example;

import com.jackl.mvparticle.inject.PerActivity;
import com.jackl.mvparticle.presenter.example.IExampleFourPresenter;
import com.jackl.mvparticle.presenter.example.impl.ExampleFourPresenter;
import com.jackl.mvparticle.view.example.example_four.IExampleFour;
import dagger.Module;
import dagger.Provides;

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
 * 创建时间: 2019/2/10 12:22
 * 版本:1.0.0
 * 描述: ExampleFourModule
 *
*/

@Module
public class ExampleFourModule {
      private IExampleFour mView;
      public ExampleFourModule(IExampleFour mView) {
            this.mView=mView;

      }

      @PerActivity
      @Provides
      public IExampleFourPresenter providesPresenter(){
            return new ExampleFourPresenter(mView);
      }
}

