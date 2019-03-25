package com.jackl.mvparticle.network.result;

import com.jackl.mvparticle.network.Exception.FactoryException;
import rx.Observable;
import rx.functions.Func1;

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
 * 创建时间: 2019/2/12 10:11
 * 版本:1.0.0
 * 描述: ExceptionFunc
 *
*/
public class ExceptionFunc implements Func1<Throwable, Observable> {

      @Override
      public Observable call(Throwable throwable) {
            return Observable.error(FactoryException.analysisExcetpion(throwable));
      }

}
