package com.jackl.mvparticle.module.lives;

import com.jackl.mvparticle.inject.PerActivity;
import com.jackl.mvparticle.presenter.lives.ILivePlayPresenter;
import com.jackl.mvparticle.presenter.lives.impl.LivePlayPresenter;
import com.jackl.mvparticle.view.live.ILivePlayInfo;
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
 * 创建时间: 2019/3/15 14:47
 * 版本:1.0.0
 * 描述: LivePlayModule
 *
*/

@Module
public class LivePlayModule {
      private ILivePlayInfo mView;
      public LivePlayModule(ILivePlayInfo mView) {
            this.mView=mView;

      }

      @PerActivity
      @Provides
      public ILivePlayPresenter providesPresenter(){
            return new LivePlayPresenter(mView);
      }
}
