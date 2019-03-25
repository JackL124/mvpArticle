package com.jackl.mvparticle.base.baseview;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import com.jackl.mvparticle.R;
import com.jackl.mvparticle.base.listener.IBasePresenter;
import com.jackl.mvparticle.base.listener.IBaseStatus;
import com.jackl.mvparticle.base.widget.LoadStatusLayout;
import com.trello.rxlifecycle.LifecycleTransformer;
import javax.inject.Inject;
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
 * 创建时间: 2019/2/19 18:20
 * 版本:1.0.0
 * 描述: BaseStatusFragment
 *
*/

public abstract class BaseStatusFragment <T extends IBasePresenter> extends BaseSwipeBackFragment implements IBaseStatus {
      @Inject
      protected T mPresenter;
      @Nullable
      @BindView(R.id.load_status_view)
      protected LoadStatusLayout loadStatusLayout;

      @SuppressLint("WrongConstant")
      @Override
      public void onLoading() {
            if (loadStatusLayout != null) {
                  loadStatusLayout.showLoading();
            }
      }

      @SuppressLint("WrongConstant")
      @Override
      public void onSuccess() {
            if (loadStatusLayout != null) {
                  loadStatusLayout.showContent();
            }
      }

      @SuppressLint("WrongConstant")
      @Override
      public void onEmpty() {
            if (loadStatusLayout != null) {
                  loadStatusLayout.showEmpty();
            }
      }

      @SuppressLint("WrongConstant")
      @Override
      public void onNetError(String message) {
            if (loadStatusLayout != null) {
                  loadStatusLayout.showNetError(message);
            }
      }

      @SuppressLint("WrongConstant")
      @Override
      public void onDataError(String message) {
            if (loadStatusLayout != null) {
                  loadStatusLayout.showDataError(message);
            }
      }

      @SuppressLint("WrongConstant")
      @Override
      public void onUnknownError(String message) {
            if (loadStatusLayout != null) {
                  loadStatusLayout.showUnknownError(message);
            }
      }

      @Override
      public <T> LifecycleTransformer<T> bindToLife() {
            return this.<T>bindToLifecycle();
      }

}
