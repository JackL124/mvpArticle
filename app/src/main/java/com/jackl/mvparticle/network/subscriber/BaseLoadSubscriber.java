package com.jackl.mvparticle.network.subscriber;

import com.jackl.mvparticle.base.listener.IBaseLoad;
import com.jackl.mvparticle.base.toast.ToastUtils;
import com.jackl.mvparticle.network.Exception.CodeException;
import com.jackl.mvparticle.network.Exception.FactoryException;
import com.jackl.mvparticle.network.Exception.ResponseException;
import com.jackl.mvparticle.network.listener.ResponseListener;

import rx.Subscriber;

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
 * 创建时间: 2019/2/19 10:01
 * 版本:1.0.0
 * 描述: BaseLoadSubscriber
 *
*/

public class BaseLoadSubscriber<T> extends Subscriber<T> {

      private IBaseLoad mView;
      private boolean visible;
      private ResponseListener<T> mSubscriberOnNextListener;

      public BaseLoadSubscriber(ResponseListener<T> listener, IBaseLoad view,boolean visible) {
            this.mSubscriberOnNextListener = listener;
            this.mView = view;
            this.visible=visible;
      }

      /**
       * 开始
       */
      @Override
      public void onStart() {
            super.onStart();
            mView.onLoading(visible);
      }

      /**
       * 完成
       */
      @Override
      public void onCompleted() {

      }

      /**
       * 对错误进行统一处理
       */
      @Override
      public void onError(Throwable e) {
            ResponseException responseException = FactoryException.analysisExcetpion(e);
            switch (responseException.getCode()){
                  /*网络问题*/
                  case CodeException.UNKOWNHOST_ERROR :
                  case CodeException.CONNECT_ERROR :
                  case CodeException.HTTP_ERROR :
                        mView.onNetError( responseException.getDisplayMessage() + "  错误代码：" + responseException.getCode());
                        if (mSubscriberOnNextListener != null) {
                              mSubscriberOnNextListener.onError(e);
                        }

                        break;
                  /*数据解析出现错误*/
                  case CodeException.JSON_ERROR :
                  case CodeException.CLASSCAST_ERROR :
                  case CodeException.INDEXOUT_ERROR :
                  case CodeException.NULLPOINTER_ERROR :
                  case CodeException.UNUMBERFORMAT_ERROR :
                        mView.onDataError(responseException.getDisplayMessage()+"  错误代码："+responseException.getCode());
                        if (mSubscriberOnNextListener != null) {
                              mSubscriberOnNextListener.onError(e);
                        }
                        break;
                  /*未知错误*/
                  case CodeException.UNKNOWN_ERROR :
                        mView.onUnknownError(responseException.getDisplayMessage());
                        if (mSubscriberOnNextListener != null) {
                              mSubscriberOnNextListener.onError(e);
                        }
                        break;
            }
      }

      /**
       * 将onNext方法中的返回结果交给Activity或Fragment自己处理
       */
      @Override
      public void onNext(T t) {
            if (mSubscriberOnNextListener != null) {
                  mSubscriberOnNextListener.onNext(t);
            }
            if (mView != null)
                mView.onSuccess();
       }
}
