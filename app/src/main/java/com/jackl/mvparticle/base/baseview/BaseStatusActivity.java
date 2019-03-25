package com.jackl.mvparticle.base.baseview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import com.jackl.mvparticle.R;
import com.jackl.mvparticle.base.listener.IBasePresenter;
import com.jackl.mvparticle.base.listener.IBaseStatus;
import com.jackl.mvparticle.base.widget.LoadStatusLayout;
import com.trello.rxlifecycle.LifecycleTransformer;
import javax.inject.Inject;
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
 * 创建时间: 2019/1/10 18:16
 * 版本:1.0.0
 * 描述: BaseStatusActivity
 *
*/
public abstract class BaseStatusActivity <T extends IBasePresenter> extends BaseSwipeBackActivity implements IBaseStatus {
    @Inject
    protected T mPresenter;
    @Nullable
    @BindView(R.id.load_status_view)
    protected LoadStatusLayout loadStatusLayout;

    @SuppressLint("WrongConstant")
    @Override
    public void onLoading() {
        if (loadStatusLayout != null) {
            loadStatusLayout.showLoading();
            loadStatusLayout.setOnNetClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(android.os.Build.VERSION.SDK_INT > 10){
                        startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
                    }else{
                        startActivity(new Intent().setClassName("com.android.settings", "com.android.settings.WirelessSettings"));
                    }
                }
            });
        }

    }

    @SuppressLint("WrongConstant")
    @Override
    public void onSuccess() {
        if (loadStatusLayout != null) {
            loadStatusLayout.showContent();
        }
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onEmpty() {
        if (loadStatusLayout != null) {
            loadStatusLayout.showEmpty();
        }
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onNetError(String message) {
        if (loadStatusLayout != null) {
            loadStatusLayout.showNetError(message);
        }
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onDataError(String message) {
        if (loadStatusLayout != null) {
            loadStatusLayout.showDataError(message);
        }
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onUnknownError(String message) {
        if (loadStatusLayout != null) {
            loadStatusLayout.showUnknownError(message);
        }
    }


    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.<T>bindToLifecycle();
    }
}
