package com.jackl.mvparticle.base.toast;

import android.app.Application;

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
 * 创建时间: 2019/3/15 15:21
 * 版本:1.0.0
 * 描述: SupportToast
 *
*/

public class SupportToast extends BaseToast {

      private final ToastHelper mToastHelper;

      SupportToast(Application application) {
            super(application);
            mToastHelper = new ToastHelper(this, application);
      }

      @Override
      public void show() {
            // 显示吐司
            mToastHelper.show();
      }

      @Override
      public void cancel() {
            // 取消显示
            mToastHelper.cancel();
      }

}
