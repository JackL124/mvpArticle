package com.jackl.mvparticle.inject.component.live;

import com.jackl.mvparticle.inject.PerFragment;
import com.jackl.mvparticle.inject.component.AppComponent;
import com.jackl.mvparticle.module.lives.LiveListModule;
import com.jackl.mvparticle.view.live.impl.LiveListFragment;
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
 * 创建时间: 2019/3/14 10:15
 * 版本:1.0.0
 * 描述: LiveListComponent
 *
*/

@PerFragment
@Component(dependencies = AppComponent.class,modules = LiveListModule.class)
public interface LiveListComponent {
      void inject(LiveListFragment fragment);
}
