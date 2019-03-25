package com.jackl.mvparticle.module.lives;

import com.jackl.mvparticle.inject.PerFragment;
import com.jackl.mvparticle.presenter.lives.ILiveListPresenter;
import com.jackl.mvparticle.presenter.lives.impl.LiveListPresenter;
import com.jackl.mvparticle.view.live.ILiveList;
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
 * 创建时间: 2019/3/14 10:11
 * 版本:1.0.0
 * 描述: LiveListModule
 *
*/

@Module
public class LiveListModule {
      private ILiveList mView;
      public LiveListModule(ILiveList mView) {
            this.mView=mView;

      }

      @PerFragment
      @Provides
      public ILiveListPresenter providesPresenter(){
            return new LiveListPresenter(mView);
      }

}
