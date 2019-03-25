package com.jackl.mvparticle.base.listener;

import com.trello.rxlifecycle.LifecycleTransformer;

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
 * 创建时间: 2019/1/18 15:17
 * 版本:1.0.0
 * 描述: IBaseLoad
 *
*/
public interface IBaseLoad {

    /**
     * 加载
     */
    void onLoading(boolean visible);

    /**
     * 加载成功
     */
    void onSuccess();


    /**
     * 无数据
     */
    void onEmpty();

    /**
     * 网络错误
     */
    void onNetError(String message);

    /**
     * 数据错误
     */
    void onDataError(String message);

    /**
     * 未知错误
     */
    void onUnknownError(String message);

    /**
     * 绑定生命周期
     * @param <T>
     */
    <T> LifecycleTransformer<T> bindToLife();

}
