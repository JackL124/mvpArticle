package com.jackl.mvparticle.network.result;
import rx.functions.Func1;

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
 * 创建时间: 2019/1/9 18:10
 * 版本:1.0.0
 * 描述: HttpResultFunc
 *
*/
public class HttpLiveResultFunc<T> implements Func1<BaseLiveResult<T>, T> {

    @Override
    public T call(BaseLiveResult<T> httpResult) {

        if (httpResult.getStatus().equals("ok")) {
            try {
//                if (!TextUtils.isEmpty(httpResult.getMsg())) {
//                    throw new Error(httpResult.getMsg());
//                } else {
//                    throw new Error("");
//                }
            } catch (Exception e) {
            }
        }
        return httpResult.getResult();
    }



}