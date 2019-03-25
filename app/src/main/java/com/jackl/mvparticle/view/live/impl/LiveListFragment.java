package com.jackl.mvparticle.view.live.impl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.jackl.mvparticle.R;
import com.jackl.mvparticle.adapter.live.LiveListAadpter;
import com.jackl.mvparticle.base.baseview.BaseLoadFragment;
import com.jackl.mvparticle.base.recyclerview.CustomLoadMoreView;
import com.jackl.mvparticle.base.recyclerview.animation.CustomAnimation;
import com.jackl.mvparticle.entity.live.LiveListItemBean;
import com.jackl.mvparticle.inject.component.live.DaggerLiveListComponent;
import com.jackl.mvparticle.module.lives.LiveListModule;
import com.jackl.mvparticle.presenter.lives.ILiveListPresenter;
import com.jackl.mvparticle.view.live.ILiveList;
import java.util.ArrayList;
import java.util.List;
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
 * 创建时间: 2019/3/14 09:09
 * 版本:1.0.0
 * 描述: LiveListFragment
 *
*/

public class LiveListFragment extends BaseLoadFragment<ILiveListPresenter> implements ILiveList, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

      @BindView(R.id.refreshlayout)
      SwipeRefreshLayout refreshLayout;
      @BindView(R.id.recyclerview)
      RecyclerView recyclerView;
      private LiveListAadpter adapter;
      private int offset = 0;
      private int limit=20;
      private final List<LiveListItemBean> liveList = new ArrayList<>();
      private String game_type;
      private static final String GAME_TYPE = "game_type";

      public static LiveListFragment newInstance(String game_type) {
            LiveListFragment fragment = new LiveListFragment();
            Bundle args = new Bundle();
            args.putString(GAME_TYPE, game_type);
            fragment.setArguments(args);
            return fragment;
      }


      @Override
      protected int getContentView() {
            return R.layout.fragment_livelist;
      }

      @Override
      protected void initInjector() {
            DaggerLiveListComponent.builder()
                      .appComponent(getAppComponent())
                      .liveListModule(new LiveListModule(this))
                      .build()
                      .inject(this);
      }

      @Override
      protected void initView() {
            setSwipeBackEnable(false);
            game_type = getArguments().getString(GAME_TYPE);
            refreshLayout.setColorSchemeResources(R.color.colorPrimary);
            refreshLayout.setOnRefreshListener(this);

      }

      @Override
      public void onLazyInitView(@Nullable Bundle savedInstanceState) {
            super.onLazyInitView(savedInstanceState);
            setRecyclerView();
            refreshLayout.setProgressViewOffset(false, 0, 30);
            refreshLayout.setRefreshing(true);
            mPresenter.getLiveList(offset,limit,"",game_type);
      }

      private void setRecyclerView() {
            adapter = new LiveListAadpter(liveList);
            recyclerView.setLayoutManager(new GridLayoutManager(_mActivity, 2));
            adapter.openLoadAnimation(new CustomAnimation());
            adapter.isFirstOnly(true);
            adapter.setPreLoadNumber(18);
            adapter.setOnLoadMoreListener(this,recyclerView);
            adapter.setLoadMoreView(new CustomLoadMoreView());
            recyclerView.setAdapter(adapter);
            recyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
                  @Override
                  public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                        LiveListItemBean bean = (LiveListItemBean) adapter.getData().get(position);
                        Intent intent = new Intent(getActivity(), LivePlayActivity.class);
                        intent.putExtra(LivePlayActivity.LIVE_TYPE, bean.getLive_type());
                        intent.putExtra(LivePlayActivity.LIVE_ID, bean.getLive_id());
                        intent.putExtra(LivePlayActivity.GAME_TYPE, bean.getGame_type());
                        startActivity(intent);
                  }

            });
      }

      @Override
      public void loadLiveListDetial(List<LiveListItemBean> list) {
            refreshLayout.setRefreshing(false);
            adapter.addData(list);
            offset = adapter.getData().size();
            if (list.size() < limit) {
                  adapter.loadMoreEnd();
            } else {
                  adapter.loadMoreComplete();
            }
      }

      @Override
      public void onNetError() {
            refreshLayout.setRefreshing(false);
            adapter.loadMoreFail();
      }

      @Override
      public void onLoadMoreRequested() {
           mPresenter.getMoreLiveList(offset,limit,"",game_type);
      }

      @Override
      public void onRefresh() {
            offset = 0;//重置偏移量
            liveList.clear();//清空原数据
            adapter.setNewData(liveList);
            adapter.removeAllFooterView();
            refreshLayout.setRefreshing(true);
            mPresenter.getLiveList(offset,limit,"",game_type);
      }
}
