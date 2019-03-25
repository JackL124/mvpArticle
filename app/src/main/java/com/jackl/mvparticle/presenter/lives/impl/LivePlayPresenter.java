package com.jackl.mvparticle.presenter.lives.impl;

import com.jackl.mvparticle.entity.live.LiveDetailBean;
import com.jackl.mvparticle.network.listener.ResponseListener;
import com.jackl.mvparticle.network.manager.HttpLiveManager;
import com.jackl.mvparticle.network.result.HttpLiveResultFunc;
import com.jackl.mvparticle.network.subscriber.BaseStatusSubscriber;
import com.jackl.mvparticle.presenter.lives.ILivePlayPresenter;
import com.jackl.mvparticle.view.live.ILivePlayInfo;


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
 * 创建时间: 2019/3/15 14:06
 * 版本:1.0.0
 * 描述: LivePlayPresenter
 *
*/

public class LivePlayPresenter implements ILivePlayPresenter {
      private final ILivePlayInfo mView;
      public LivePlayPresenter(ILivePlayInfo mView) {
            this.mView = mView;
      }

      @Override
      public void getData() {

      }

      @Override
      public void getLiveInfoList(String live_id, String live_type, String game_type) {
            HttpLiveManager.getInstance().getLiveDetail(live_id, live_type, game_type)
                      .compose(mView.bindToLife())
                      .map(new HttpLiveResultFunc<LiveDetailBean>())
                      .subscribe(new BaseStatusSubscriber(new ResponseListener<LiveDetailBean>(){
                            @Override
                            public void onNext(LiveDetailBean liveDetailBean) {
                                  mView.getLivePlayInfo(liveDetailBean);
                            }
                      },mView));
      }
}
