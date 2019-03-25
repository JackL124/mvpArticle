package com.jackl.mvparticle.network.api;

import com.jackl.mvparticle.entity.Register.LoginBean;
import com.jackl.mvparticle.network.cache.headers.CacheHeaders;
import com.jackl.mvparticle.network.result.BaseLiveResult;
import com.jackl.mvparticle.network.result.BaseRegisterResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;
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
 * 创建时间: 2019/1/9 16:45
 * 版本:1.0.0
 * 描述: RegisterApi   注册登录相关接口
 *
*/
public interface RegisterApi {

     /**
      * @Author: JackL
      * @params:
      * @return:
      * 创建时间: 2019/1/9 15:46
      * 版本:1.0.0
      * 描述: 登录接口
      *
     */
     @Headers({CacheHeaders.NORMAL})
     @POST("/login")
     @FormUrlEncoded
     Observable<BaseRegisterResult<LoginBean>> login(@Field("username") String username,
                                                     @Field("password") String password,
                                                     @Field("platform") String platform,
                                                     @Field("registrationId") String registrationId);
}

