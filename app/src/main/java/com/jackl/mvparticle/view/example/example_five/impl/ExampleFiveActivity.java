package com.jackl.mvparticle.view.example.example_five.impl;

import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.jackl.mvparticle.R;
import com.jackl.mvparticle.base.baseview.BaseStatusActivity;
import com.jackl.mvparticle.entity.Register.LoginBean;
import com.jackl.mvparticle.inject.component.example.DaggerExampleFiveComponent;
import com.jackl.mvparticle.module.example.ExampleFiveModule;
import com.jackl.mvparticle.presenter.example.IExampleFivePresenter;
import com.jackl.mvparticle.view.example.example_five.IExampleFive;
import butterknife.BindView;

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
 * 创建时间: 22019/1/9 17:01
 * 版本:1.0.0
 * 描述: ExampleFiveActivity
 *
*/

public class ExampleFiveActivity extends BaseStatusActivity<IExampleFivePresenter> implements IExampleFive {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.content_tv)
    TextView content_tv;

    @Override
    protected int getContentView() {
        return R.layout.activity_examplefive;
    }

    @Override
    protected void initInjector() {
        DaggerExampleFiveComponent.builder()
                .appComponent(getAppComponent())
                .exampleFiveModule(new ExampleFiveModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void beforeLayout() {
        super.beforeLayout();

    }

    @Override
    protected void initView() {
        initToolBar(mToolbar,"案例5");
        mPresenter.login("18000000006","111111","android","");

    }

    @Override
    public void getUserInfo(LoginBean bean) {
        content_tv.setText(bean.toString());
    }
}
