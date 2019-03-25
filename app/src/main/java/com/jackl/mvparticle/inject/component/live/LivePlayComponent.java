package com.jackl.mvparticle.inject.component.live;

import com.jackl.mvparticle.inject.PerActivity;
import com.jackl.mvparticle.inject.component.AppComponent;
import com.jackl.mvparticle.module.lives.LivePlayModule;
import com.jackl.mvparticle.view.live.impl.LivePlayActivity;
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
 * 创建时间: 2019/3/15 14:52
 * 版本:1.0.0
 * 描述: LivePlayComponent
 *
*/
@PerActivity
@Component(dependencies = AppComponent.class,modules = LivePlayModule.class)
public interface LivePlayComponent {
    void inject(LivePlayActivity livePlayActivity);
}
