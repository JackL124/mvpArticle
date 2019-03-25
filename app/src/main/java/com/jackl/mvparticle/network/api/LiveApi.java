package com.jackl.mvparticle.network.api;

import com.jackl.mvparticle.entity.live.LiveDetailBean;
import com.jackl.mvparticle.entity.live.LiveListItemBean;
import com.jackl.mvparticle.network.result.BaseLiveResult;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;
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
 * 创建时间: 2019/1/23 11:41
 * 版本:1.0.0
 * 描述: LiveApi
 *
*/

public interface LiveApi {

      //请求获取不同游戏的直播列表
      @GET("/api/live/list/")
      Observable<BaseLiveResult<List<LiveListItemBean>>> getLiveList(
                @Query("offset") int offset,
                @Query("limit") int limit,
                @Query("live_type") String live_type,
                @Query("game_type") String game_type
      );

      //请求获取直播详情
      @GET("/api/live/detail/")
      Observable<BaseLiveResult<LiveDetailBean>> getLiveDetail(
                @Query("live_type") String live_type,
                @Query("live_id") String live_id,
                @Query("game_type") String game_type
      );
}
