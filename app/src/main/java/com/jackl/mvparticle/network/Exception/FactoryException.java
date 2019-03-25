package com.jackl.mvparticle.network.Exception;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import retrofit2.adapter.rxjava.HttpException;

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
 * 创建时间: 2019/2/12 14:44
 * 版本:1.0.0
 * 描述: FactoryException
 *
*/
public class FactoryException {

      private static final String HttpException_MSG = "网络错误";
      private static final String ConnectException_MSG = "服务器连接失败";
      private static final String JSONException_MSG = "数据解析出现错误";
      private static final String UnknownHostException_MSG = "找不到服务器,请检查网络是否通畅";
      private static final String CLASSCAST_MSG = "类型转换失败";
      private static final String INDEXOUT_MSG = "数据下标越界";
      private static final String NULLPOINTER_MSG = "对象数据未初始化";
      private static final String UNUMBERFORMAT_MSG = "数字无法格式化";
      public static final String UnknownException_MSG = "未知错误";
      /**
       * 解析异常
       *
       * @param e
       * @return
       */
      public static ResponseException analysisExcetpion(Throwable e) {
            ResponseException responseException = new ResponseException(e);
            if (e instanceof HttpException) {
                  /*网络异常*/
                  responseException.setCode(CodeException.HTTP_ERROR);
                  responseException.setDisplayMessage(HttpException_MSG);
            } else if (e instanceof ConnectException ||e instanceof SocketTimeoutException) {
                  /*链接异常*/
                  responseException.setCode(CodeException.CONNECT_ERROR);
                  responseException.setDisplayMessage(ConnectException_MSG);
            } else if (e instanceof JsonParseException || e instanceof JsonIOException || e instanceof JsonSyntaxException) {
                  /*json解析异常*/
                  responseException.setCode(CodeException.JSON_ERROR);
                  responseException.setDisplayMessage(JSONException_MSG);
            }else if (e instanceof UnknownHostException){
                  /*无法解析该域名异常*/
                  responseException.setCode(CodeException.UNKOWNHOST_ERROR);
                  responseException.setDisplayMessage(UnknownHostException_MSG);
            }else if (e instanceof ClassCastException ){
                  /*数据类型转换异常*/
                  responseException.setCode(CodeException.CLASSCAST_ERROR);
                  responseException.setDisplayMessage(CLASSCAST_MSG);
            }else if (e instanceof IndexOutOfBoundsException|| e instanceof ArrayIndexOutOfBoundsException|| e instanceof StringIndexOutOfBoundsException){
                  /*下标越界异常*/
                  responseException.setCode(CodeException.INDEXOUT_ERROR);
                  responseException.setDisplayMessage(INDEXOUT_MSG);
            }else if (e instanceof NullPointerException){
                  /*空指针异常*/
                  responseException.setCode(CodeException.NULLPOINTER_ERROR);
                  responseException.setDisplayMessage(NULLPOINTER_MSG);
            }else if (e instanceof NumberFormatException){
                  /*数字格式化异常*/
                  responseException.setCode(CodeException.UNUMBERFORMAT_ERROR);
                  responseException.setDisplayMessage(UNUMBERFORMAT_MSG);
            }
            else {
                  /*未知异常*/
                  responseException.setCode(CodeException.UNKNOWN_ERROR);
                  responseException.setDisplayMessage(UnknownException_MSG);
            }
            return responseException;
      }
}
