package com.jackl.mvparticle.base.baseview;

import com.jackl.mvparticle.base.listener.IBaseLoad;
import com.jackl.mvparticle.base.listener.IBasePresenter;
import com.jackl.mvparticle.base.toast.ToastUtils;
import com.jackl.mvparticle.base.widget.LoadViewDialog;
import com.trello.rxlifecycle.LifecycleTransformer;

import javax.inject.Inject;

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
 * 创建时间: 2019/2/19 18:01
 * 版本:1.0.0
 * 描述: BaseLoadFragment
 *
*/

public abstract class BaseLoadFragment <T extends IBasePresenter>  extends BaseSwipeBackFragment implements IBaseLoad {
      @Inject
      protected T mPresenter;
      protected LoadViewDialog ld = null;
      protected String loadTag="LOADVIEW";
      protected boolean visible;
      @Override
      public void onLoading(boolean visible) {
            this.visible=visible;
            if(visible){
                  if (ld == null){
                        ld =new LoadViewDialog();
                  }
                  showLoadView();
            }
      }

      @Override
      public void onSuccess() {
            if(visible){
                  dismissLoadView();
            }
      }

      @Override
      public void onEmpty() {
            if(visible){
                  dismissLoadView();
            }
            ToastUtils.show("没有内容了");
      }

      @Override
      public void onDataError(String message) {
            if(visible){
                  dismissLoadView();
            }
            ToastUtils.show(message);
      }

      @Override
      public void onNetError(String message) {
            if(visible){
                  dismissLoadView();
            }
            ToastUtils.show(message);
      }

      @Override
      public void onUnknownError(String message) {
            if(visible){
                  dismissLoadView();
            }
            ToastUtils.show(message);
      }


      protected void showLoadView(){
            if (!ld.isAdded()) {
                  ld.show(getFragmentManager(),loadTag);
            }
      }

      protected void dismissLoadView() {
            ld.stopAnim();
            ld.dismiss();
      }

      @Override
      public <T> LifecycleTransformer<T> bindToLife() {
            return this.<T>bindToLifecycle();
      }

}
