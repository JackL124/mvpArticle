package com.jackl.mvparticle.inject.component;

import android.content.Context;
import com.jackl.mvparticle.base.MyApplication;
import com.jackl.mvparticle.module.AppModule;
import com.jackl.mvparticle.rxBus.RxBus;
import javax.inject.Singleton;
import dagger.Component;

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
 * 描述: AppComponent
 *
*/

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Context getContext();
    void inject(MyApplication app);
    RxBus getRxBus();
}
