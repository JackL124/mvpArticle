package com.jackl.mvparticle.module.example;

import com.jackl.mvparticle.inject.PerActivity;
import com.jackl.mvparticle.presenter.example.IExampleFivePresenter;
import com.jackl.mvparticle.presenter.example.impl.ExampleFivePresenter;
import com.jackl.mvparticle.view.example.example_five.IExampleFive;
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
 * 创建时间: 2019/1/14 15:00
 * 版本:1.0.0
 * 描述: LoginModule
 *
*/

@Module
public class ExampleFiveModule {
    private IExampleFive view;


    public ExampleFiveModule(IExampleFive view) {
        this.view = view;

    }

    @PerActivity
    @Provides
    public IExampleFivePresenter providePresenter() {
        return new ExampleFivePresenter(view);
    }

}
