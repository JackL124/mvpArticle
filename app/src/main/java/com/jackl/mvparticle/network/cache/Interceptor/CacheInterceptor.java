package com.jackl.mvparticle.network.cache.Interceptor;

import android.content.Context;
import com.jackl.mvparticle.network.cache.CacheManager;
import com.jackl.mvparticle.network.cache.CacheType;
import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


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
 * 创建时间: 2019/2/15 15:54
 * 版本:1.0.0
 * 描述: CacheInterceptor   okhttp 缓存拦截器 处理缓存
 *
*/

public class CacheInterceptor implements Interceptor {
      private Context context;

      public void setContext(Context context)
      {
            this.context = context;
      }

      public CacheInterceptor(Context context)
      {
            this.context = context;
      }

      @Override
      public Response intercept(Chain chain) throws IOException
      {
            Request request = chain.request();
            String cacheHead = request.header("cache");
            String cache_control = request.header("Cache-Control");

            if ("true".equals(cacheHead) ||                              // 缓存
                      (cache_control != null && !cache_control.isEmpty()))
            {
                  long oldnow = System.currentTimeMillis();
                  String url = request.url().url().toString();
                  String responStr = null;
                  String reqBodyStr = getPostParams(request);
                  try
                  {
                        Response response = chain.proceed(request);

                        if (response.isSuccessful())
                        {
                              ResponseBody responseBody = response.body();
                              if (responseBody != null)
                              {
                                    responStr = responseBody.string();
                                    if (responStr == null)
                                    {
                                          responStr = "";
                                    }
                                    CacheManager.getInstance(context).setCache(CacheManager.encryptMD5(url + reqBodyStr), responStr);//存缓存，以链接+参数进行MD5编码为KEY存
                              }
                              return getOnlineResponse(response, responStr);
                        } else
                        {
                              return chain.proceed(request);
                        }
                  } catch (Exception e)
                  {
                        e.printStackTrace();
                        Response response = getCacheResponse(request, oldnow); // 发生异常了，我这里就开始去缓存，但是有可能没有缓存，那么久需要丢给下一轮处理了
                        if (response == null)
                        {
                              return chain.proceed(request);//丢给下一轮处理
                        } else
                        {
                              return response;
                        }
                  }
            } else
            {
                  return chain.proceed(request);
            }
      }

      private Response getCacheResponse(Request request, long oldNow)
      {
            String url = request.url().url().toString();
            String params = getPostParams(request);
            String cacheStr = CacheManager.getInstance(context).getCache(CacheManager.encryptMD5(url + params));//取缓存，以链接+参数进行MD5编码为KEY取
            if (cacheStr == null)
            {
                  return null;
            }
            Response response = new Response.Builder()
                      .code(200)
                      .body(ResponseBody.create(null, cacheStr))
                      .request(request)
                      .message(CacheType.DISK_CACHE)
                      .protocol(Protocol.HTTP_1_0)
                      .build();
            return response;
      }

      private Response getOnlineResponse(Response response, String body)
      {
            ResponseBody responseBody = response.body();
            return new Response.Builder()
                      .code(response.code())
                      .body(ResponseBody.create(responseBody == null ? null : responseBody.contentType(), body))
                      .request(response.request())
                      .message(response.message())
                      .protocol(response.protocol())
                      .build();
      }

      /**
       * Post 获取request参数
       *
       * @param request
       * @return
       */
      private String getPostParams(Request request)
      {
            String reqBodyStr = "";
            String method = request.method();
            if ("POST".equals(method)) // 如果是Post，则尽可能解析每个参数
            {
                  StringBuilder sb = new StringBuilder();
                  if (request.body() instanceof FormBody)
                  {
                        FormBody body = (FormBody) request.body();
                        if (body != null)
                        {
                              for (int i = 0; i < body.size(); i++)
                              {
                                    sb.append(body.encodedName(i)).append("=").append(body.encodedValue(i)).append(",");
                              }
                              sb.delete(sb.length() - 1, sb.length());
                        }
                        reqBodyStr = sb.toString();
                        sb.delete(0, sb.length());
                  }
            }
            return reqBodyStr;
      }
}
