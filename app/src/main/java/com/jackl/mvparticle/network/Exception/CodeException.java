package com.jackl.mvparticle.network.Exception;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


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
 * 创建时间: 2019/2/12 13:57
 * 版本:1.0.0
 * 描述: CodeException
 *
*/
public class CodeException {
      /*连接错误*/
      public static final int CONNECT_ERROR = 10000002;
      /*http错误*/
      public static final int HTTP_ERROR = 10000003;
      /*json错误*/
      public static final int JSON_ERROR = 10000004;
      /*无法解析该域名*/
      public static final int UNKOWNHOST_ERROR = 10000005;
      /*类型转换失败*/
      public static final int CLASSCAST_ERROR = 10000006;
      /*数据下标越界*/
      public static final int INDEXOUT_ERROR = 10000007;
      /*对象数据未初始化*/
      public static final int NULLPOINTER_ERROR = 10000008;
      /*数字无法格式化*/
      public static final int UNUMBERFORMAT_ERROR = 10000009;
      /*未知错误*/
      public static final int UNKNOWN_ERROR = 10000010;


      @IntDef({CONNECT_ERROR,HTTP_ERROR, UNKNOWN_ERROR, JSON_ERROR, CLASSCAST_ERROR, INDEXOUT_ERROR, NULLPOINTER_ERROR, UNUMBERFORMAT_ERROR, UNKOWNHOST_ERROR})
      @Retention(RetentionPolicy.SOURCE)

      public @interface CodeEp {
      }
}
