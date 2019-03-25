package com.jackl.mvparticle.module;

import android.content.Context;

import com.jackl.mvparticle.base.MyApplication;
import com.jackl.mvparticle.rxBus.RxBus;

import javax.inject.Singleton;

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
 * 创建时间: 2019/1/11 9:25
 * 版本:1.0.0
 * 描述: AppModule
 *
*/
@Module
public class AppModule {
    private MyApplication app;
    private RxBus mRxBus;

    public AppModule(MyApplication app, RxBus mRxBus) {
        this.app = app;
        this.mRxBus = mRxBus;
    }

    @Provides
    @Singleton
    Context provideAppContext() {
        return app;
    }

    @Provides
    @Singleton
    RxBus provideRxBus() {
        return mRxBus;
    }
}
