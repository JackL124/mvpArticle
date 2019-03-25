package com.jackl.mvparticle.inject.component.example;


import com.jackl.mvparticle.inject.PerActivity;
import com.jackl.mvparticle.inject.component.AppComponent;
import com.jackl.mvparticle.module.example.ExampleFiveModule;
import com.jackl.mvparticle.view.example.example_five.impl.ExampleFiveActivity;

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
 * 创建时间: 2019/1/14 15:33
 * 版本:1.0.0
 * 描述: LoginComponent
 *
*/
@PerActivity
@Component(dependencies = AppComponent.class,modules = ExampleFiveModule.class)
public interface ExampleFiveComponent {
    void inject(ExampleFiveActivity activity);
}
