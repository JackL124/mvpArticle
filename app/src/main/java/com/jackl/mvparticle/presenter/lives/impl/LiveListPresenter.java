package com.jackl.mvparticle.presenter.lives.impl;

import com.jackl.mvparticle.entity.live.LiveListItemBean;
import com.jackl.mvparticle.network.listener.ResponseListener;
import com.jackl.mvparticle.network.manager.HttpLiveManager;
import com.jackl.mvparticle.network.result.HttpLiveResultFunc;
import com.jackl.mvparticle.network.subscriber.BaseLoadSubscriber;
import com.jackl.mvparticle.presenter.lives.ILiveListPresenter;
import com.jackl.mvparticle.view.live.ILiveList;
import java.util.List;

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
 * 创建时间: 2019/3/14 09:30
 * 版本:1.0.0
 * 描述: LiveListPresenter
 *
*/

public class LiveListPresenter implements ILiveListPresenter {
      private final ILiveList mView;
      public LiveListPresenter(ILiveList mView) {
            this.mView = mView;
      }

      @Override
      public void getData() {
      }


      @Override
      public void getLiveList(int offset, int limit, String live_type, String game_type) {
            HttpLiveManager.getInstance().getLiveList( offset, limit,  live_type, game_type)
                      .compose(mView.bindToLife())
                      .map(new HttpLiveResultFunc<List<LiveListItemBean>>())
                      .subscribe(new BaseLoadSubscriber(new ResponseListener<List<LiveListItemBean>>(){
                            @Override
                            public void onNext(List<LiveListItemBean> liveListItemBeanList) {
                                  mView.loadLiveListDetial(liveListItemBeanList);
                            }
                            @Override
                            public void onError(Throwable e) {
                                  super.onError(e);
                                  mView.onNetError();
                            }
                      },mView,true));
      }

      @Override
      public void getMoreLiveList(int offset, int limit, String live_type, String game_type) {
            HttpLiveManager.getInstance().getLiveList( offset, limit,  live_type, game_type)
                      .compose(mView.bindToLife())
                      .map(new HttpLiveResultFunc<List<LiveListItemBean>>())
                      .subscribe(new BaseLoadSubscriber(new ResponseListener<List<LiveListItemBean>>(){
                            @Override
                            public void onNext(List<LiveListItemBean> liveListItemBeanList) {
                                  mView.loadLiveListDetial(liveListItemBeanList);
                            }

                            @Override
                            public void onError(Throwable e) {
                                  super.onError(e);
                                  mView.onNetError();
                            }
                      },mView,false));
      }
}
