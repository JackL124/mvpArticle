package com.jackl.mvparticle.presenter.example.impl;

import android.os.Handler;

import com.jackl.mvparticle.network.Exception.FactoryException;
import com.jackl.mvparticle.network.Exception.ResponseException;
import com.jackl.mvparticle.presenter.example.IExampleThreePresenter;
import com.jackl.mvparticle.view.example.example_three.IExampleThree;
import java.net.SocketTimeoutException;


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
 * 创建时间: 2019/2/10 12:07
 * 版本:1.0.0
 * 描述: ExampleThreePresenter
 *
*/
public class ExampleThreePresenter implements IExampleThreePresenter {
      private final IExampleThree mView;

      public ExampleThreePresenter(IExampleThree mView) {
            this.mView = mView;
      }

      @Override
      public void getExampleData(final String code) {
            mView.onLoading(true);
            /**
             * @Author: JackL
             * @params: [code]
             * @return: void
             * 创建时间: 2019/3/20 20:39
             * 版本:1.0.0
             * 描述: getExampleData 模拟网络时延
             *
            */

            new Handler().postDelayed(new Runnable() {
                  @Override
                  public void run() {
                        showView(code);
                  }
            }, 3000);
      }

      private void showView(String code) {

            switch (code) {

                  case "empty":
                        mView.onEmpty();
                        break;
                  case "data_error":
                        NullPointerException nullPointerException = new NullPointerException();
                        ResponseException responseException1 = FactoryException.analysisExcetpion(nullPointerException);
                        mView.onDataError(responseException1.getDisplayMessage() + "  错误代码：" + responseException1.getCode());
                        break;
                  case "network_error":
                        SocketTimeoutException socketTimeoutException = new SocketTimeoutException();
                        ResponseException responseException2 = FactoryException.analysisExcetpion(socketTimeoutException);
                        mView.onNetError(responseException2.getDisplayMessage() + "  错误代码：" + responseException2.getCode());
                        break;

                  case "unknown_error":
                        SecurityException securityException = new SecurityException();
                        ResponseException responseException3 = FactoryException.analysisExcetpion(securityException);
                        mView.onUnknownError(responseException3.getDisplayMessage() + "  错误代码：" + responseException3.getCode());
                        break;

                  case "content":
                        mView.onSuccess();
                        break;
            }

      }

      @Override
      public void getData() {
            mView.getResultInfo("dsa");
      }
}
