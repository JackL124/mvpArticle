package com.jackl.mvparticle.inject.component.example;

import com.jackl.mvparticle.inject.PerActivity;
import com.jackl.mvparticle.inject.component.AppComponent;
import com.jackl.mvparticle.module.example.ExampleFourModule;
import com.jackl.mvparticle.view.example.example_four.impl.ExampleFourActivity;
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
 * 创建时间: 2019/3/12 14:35
 * 版本:1.0.0
 * 描述: ExampleFourComponent
 *
*/

@PerActivity
@Component(dependencies = AppComponent.class,modules = ExampleFourModule.class)
public interface ExampleFourComponent {
      void inject(ExampleFourActivity activity);
}



