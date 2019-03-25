package com.jackl.mvparticle.base;

import android.app.Application;
import android.content.Context;
import com.jackl.mvparticle.base.toast.ToastUtils;
import com.jackl.mvparticle.base.toast.style.ToastWhiteStyle;
import com.jackl.mvparticle.inject.component.AppComponent;
import com.jackl.mvparticle.inject.component.DaggerAppComponent;
import com.jackl.mvparticle.module.AppModule;
import com.jackl.mvparticle.rxBus.RxBus;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

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
 * 创建时间: 2019/1/10 15:45
 * 版本:1.0.0
 * 描述: MyApplication
 *
 */
public class MyApplication extends Application {
    public static MyApplication myApplication;
    private static AppComponent mAppComponent;
    private static Context mAppContext;
    private static Context mContext;
    private static RxBus rxBus;
    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        rxBus = new RxBus();
        mAppContext = getApplicationContext();
        mContext = getApplication();
        init();
        initInject();
    }

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }

    public  static RxBus getRxBus(){
        return rxBus;
    }

    public static Context getContext() {
        return mContext;
    }

    public static Context getAppContext(){
        return mAppContext;
    }

    public  Application getApplication() {
        return myApplication;
    }

    private void init() {

        //初始化Stetho调试工具
        Stetho.initialize(Stetho.newInitializerBuilder(mContext)
                  .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                  .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                  .build());

        //初始化Leak内存泄露检测工具
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
        ToastUtils.init(this, new ToastWhiteStyle());
    }

    private void initInject() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, rxBus))
                .build();

    }


}