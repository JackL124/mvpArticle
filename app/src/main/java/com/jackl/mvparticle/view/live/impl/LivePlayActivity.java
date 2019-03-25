package com.jackl.mvparticle.view.live.impl;

import android.content.Intent;
import android.os.PowerManager;
import android.support.v7.widget.Toolbar;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;

import com.jackl.mvparticle.R;
import com.jackl.mvparticle.base.baseview.BaseStatusActivity;
import com.jackl.mvparticle.base.swipeback.anim.DefaultHorizontalAnimator;
import com.jackl.mvparticle.base.swipeback.anim.FragmentAnimator;
import com.jackl.mvparticle.base.toast.ToastUtils;
import com.jackl.mvparticle.entity.live.LiveDetailBean;
import com.jackl.mvparticle.inject.component.live.DaggerLivePlayComponent;
import com.jackl.mvparticle.module.lives.LivePlayModule;
import com.jackl.mvparticle.presenter.lives.ILivePlayPresenter;
import com.jackl.mvparticle.view.live.ILivePlayInfo;
import com.pili.pldroid.player.AVOptions;
import com.pili.pldroid.player.PLMediaPlayer;

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
 * 创建时间: 2019/3/15 13:13
 * 版本:1.0.0
 * 描述: LivePlayActivity
 *
*/
public class LivePlayActivity extends BaseStatusActivity<ILivePlayPresenter> implements ILivePlayInfo,PLMediaPlayer.OnPreparedListener, PLMediaPlayer.OnInfoListener, PLMediaPlayer.OnErrorListener {
      @BindView(R.id.layout_top)
      FrameLayout layout_top;
      @BindView(R.id.surfaceview)
      SurfaceView surfaceView;
      @BindView(R.id.progressbar)
      FrameLayout progressbar;
      @BindView(R.id.toolbar)
      Toolbar mToolbar;

      public static final String LIVE_TYPE = "live_type"; //直播平台
      public static final String LIVE_ID = "live_id";     //直播房间ID
      public static final String GAME_TYPE = "game_type"; //直播游戏类型
      private PLMediaPlayer mediaPlayer;
      private boolean isVideoPrepared = false;
      private List<LiveDetailBean.StreamListBean> streamList = new ArrayList<>();//直播流列表
      private String live_type;   //直播平台
      private String live_id;     //直播房间号ID
      private String game_type;   //直播游戏类型
      private String live_url;   //直播url

      @Override
      protected int getContentView() {
            return R.layout.activity_liveplay;
      }

      @Override
      protected void initInjector() {
            DaggerLivePlayComponent.builder()
                      .appComponent(getAppComponent())
                      .livePlayModule(new LivePlayModule(this))
                      .build()
                      .inject(this);
      }

      @Override
      protected void beforeLayout() {
            super.beforeLayout();
      }

      @Override
      protected void initView() {
            initToolBar(mToolbar,"直播");
            loadRootFragment(R.id.layout_container, new CommentFragment());
            Intent intent = getIntent();
            live_type = intent.getStringExtra(LIVE_TYPE);
            live_id = intent.getStringExtra(LIVE_ID);
            game_type = intent.getStringExtra(GAME_TYPE);
            mPresenter.getLiveInfoList(live_id,live_type,game_type);
            surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
                  @Override
                  public void surfaceCreated(SurfaceHolder holder) {
                        progressbar.setVisibility(View.VISIBLE);
                        prepareMediaPlayer();
                  }

                  @Override
                  public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

                  }

                  @Override
                  public void surfaceDestroyed(SurfaceHolder holder) {
                        if (mediaPlayer != null) {
                              mediaPlayer.setDisplay(null);
                        }
                  }
            });
      }

      private void prepareMediaPlayer() {

            if (mediaPlayer != null) {
                  mediaPlayer.setDisplay(surfaceView.getHolder());
                  return;
            }
            try {
                  AVOptions avOptions = new AVOptions();
                  avOptions.setInteger(AVOptions.KEY_LIVE_STREAMING, 0);  //直播流：1->是 0->否
                  avOptions.setInteger(AVOptions.KEY_MEDIACODEC, 0);      //解码类型 1->硬解 0->软解
                  avOptions.setInteger(AVOptions.KEY_START_ON_PREPARED, 0);//缓冲结束后自动播放
                  avOptions.setInteger(AVOptions.KEY_DELAY_OPTIMIZATION, 1);
                  avOptions.setInteger(AVOptions.KEY_PREPARE_TIMEOUT, 10 * 1000);
                  avOptions.setInteger(AVOptions.KEY_BUFFER_TIME, 10 * 1000);
                  avOptions.setInteger(AVOptions.KEY_GET_AV_FRAME_TIMEOUT, 10 * 1000);
                  avOptions.setInteger(AVOptions.KEY_CACHE_BUFFER_DURATION, 10 * 1000);
                  avOptions.setInteger(AVOptions.KEY_MAX_CACHE_BUFFER_DURATION, 15 * 1000);

                  mediaPlayer = new PLMediaPlayer(this, avOptions);
                  mediaPlayer.setOnPreparedListener(this);
                  mediaPlayer.setOnInfoListener(this);
                  mediaPlayer.setOnErrorListener(this);
                  mediaPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
                  mediaPlayer.setDisplay(surfaceView.getHolder());
                  mediaPlayer.prepareAsync();
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }

      @Override
      public void onBackPressedSupport() {
            super.onBackPressedSupport();
      }

      @Override
      public FragmentAnimator onCreateFragmentAnimator() {
            return new DefaultHorizontalAnimator();
      }

      @Override
      public void onPrepared(PLMediaPlayer plMediaPlayer) {
            progressbar.setVisibility(isVideoPrepared ? View.GONE : View.VISIBLE);
            mediaPlayer.start();
      }

      @Override
      public boolean onInfo(PLMediaPlayer plMediaPlayer, int what, int extra) {
            switch (what) {
                  case PLMediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START://视频缓冲完成可播放
                        progressbar.setVisibility(View.GONE);
                        isVideoPrepared = true;
                        break;
            }
            return true;
      }

      @Override
      public boolean onError(PLMediaPlayer plMediaPlayer, int errorCode) {
            progressbar.setVisibility(View.GONE);
            ToastUtils.show(errorCode+"");
            return true;
      }

      @Override
      public void getLivePlayInfo(LiveDetailBean liveDetailBean) {
            try {
                  streamList = liveDetailBean.getStream_list();
                  LiveDetailBean.StreamListBean streamListBean = streamList.get(streamList.size() - 1);
                  live_url = streamListBean.getUrl();
                  mediaPlayer.setDataSource(live_url);//加载直播链接进行播放
                  mediaPlayer.prepareAsync();
            }catch (Exception e){
                  ToastUtils.show(e.getMessage()+"");
            }
      }

      @Override
      protected void onDestroy() {
            super.onDestroy();
            if(mediaPlayer!=null){
                  mediaPlayer.stop();
                  mediaPlayer.release();
                  mediaPlayer=null;
            }
      }
}
