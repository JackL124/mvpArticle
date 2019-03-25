package com.jackl.mvparticle.network.Exception;

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
 * 创建时间: 2019/2/12 13:49
 * 版本:1.0.0
 * 描述: ResponseException
 *
*/
public class ResponseException extends Exception{
      /*错误码*/
      private int code;
      /*显示的信息*/
      private String displayMessage;

      public ResponseException(Throwable e) { super(e);
      }

      public ResponseException(Throwable cause,@CodeException.CodeEp int code, String showMsg) {
            super(showMsg, cause);
            setCode(code);
            setDisplayMessage(showMsg);
      }

      @CodeException.CodeEp
      public int getCode() {
            return code;
      }

      public void setCode(@CodeException.CodeEp int code) {
            this.code = code;
      }

      public String getDisplayMessage() {
            return displayMessage;
      }

      public void setDisplayMessage(String displayMessage) {
            this.displayMessage = displayMessage;
      }
}
