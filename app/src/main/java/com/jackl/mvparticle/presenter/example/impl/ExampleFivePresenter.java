package com.jackl.mvparticle.presenter.example.impl;

import com.jackl.mvparticle.entity.Register.LoginBean;
import com.jackl.mvparticle.network.listener.ResponseListener;
import com.jackl.mvparticle.network.manager.HttpRegisterManager;
import com.jackl.mvparticle.network.result.HttpRegisterResultFunc;
import com.jackl.mvparticle.network.subscriber.BaseStatusSubscriber;
import com.jackl.mvparticle.presenter.example.IExampleFivePresenter;
import com.jackl.mvparticle.view.example.example_five.IExampleFive;

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
 * 创建时间: 2019/1/9 17:44
 * 版本:1.0.0
 * 描述: LoginPresenter
 *
*/
public class ExampleFivePresenter implements IExampleFivePresenter {
    private final IExampleFive mView;



    public ExampleFivePresenter(IExampleFive view) {
        this.mView = view;
    }


    @Override
    public void getData() {

    }

    @Override
    public void login(String username, String password, String platform, String registrationId) {

        HttpRegisterManager.getInstance().login(username,password,platform,registrationId)
                .compose(mView.bindToLife())
                .map(new HttpRegisterResultFunc<LoginBean>())
                .subscribe(new BaseStatusSubscriber(new ResponseListener<LoginBean>() {
            @Override
            public void onNext(LoginBean loginBean) {
                mView.getUserInfo(loginBean);

                }
            },mView));
    }
}
