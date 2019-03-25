package com.jackl.mvparticle.network.manager;


import com.jackl.mvparticle.base.MyApplication;
import com.jackl.mvparticle.network.Exception.RetryWhenNetworkException;
import com.jackl.mvparticle.network.api.RegisterApi;
import com.jackl.mvparticle.network.cache.Interceptor.CacheInterceptor;
import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


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
 * 创建时间: 2019/1/9 13:36
 * 版本:1.0.0
 * 描述: HttpManager  封装Retrofit + okhttp+ rxAndroid
 *
*/

public class HttpRegisterManager {

      /**
       * 连接超时时间-默认15秒
       */
      public static int CONNECTION_TIME = 15;

      /**
       * 写的超时时间-默认120秒
       */
      public static int WRITETIMEOUT = 120;

      /**
       * 读取超时时间-默认120秒
       */
      public static int READTIMEOUT = 120;

      /**
       * 最大缓存大小-默认20Mb
       */
      public static int CACHESIZE = 1024 * 1024 * 20;


      private static final String BASE_HOST = "http://testapi.solar.tanwin.cn";
      private static HttpRegisterManager httpRegisterManager;
      private static OkHttpClient mOkHttpClient;
      private static RegisterApi registerApi;

      public static HttpRegisterManager getInstance() {
            if (httpRegisterManager == null) {
                  synchronized (HttpRegisterManager.class) {
                        if (httpRegisterManager == null) {
                              httpRegisterManager = new HttpRegisterManager();
                        }
                  }
            }
            return httpRegisterManager;
      }


      private HttpRegisterManager() {
            //设置okhttp log拦截器
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            //APP缓存中设置20Mb大小的缓存区
            File cacheDir = MyApplication.getAppContext().getCacheDir();
            File file = new File(cacheDir, "HttpCache");
            Cache cache = new Cache(file, CACHESIZE);

            mOkHttpClient = new OkHttpClient.Builder()
                      .addInterceptor(loggingInterceptor)
                      .addInterceptor(new CacheInterceptor(MyApplication.getAppContext()))
                      .cache(cache)
                      .retryOnConnectionFailure(true)
                      .connectTimeout(CONNECTION_TIME, TimeUnit.SECONDS)
                      .writeTimeout(WRITETIMEOUT, TimeUnit.SECONDS)
                      .readTimeout(READTIMEOUT, TimeUnit.SECONDS)
                      .build();

            Retrofit retrofit = new Retrofit.Builder()
                      .client(mOkHttpClient)
                      .addConverterFactory(GsonConverterFactory.create())
                      .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                      .baseUrl(BASE_HOST)
                      .build();
            registerApi = retrofit.create(RegisterApi.class);
      }

//       废弃 此方式只适用 get请求缓存数据
//      private class NetCacheInterceptor implements Interceptor {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                  Request request = chain.request();
//                  Response response = chain.proceed(request);
//                  return response.newBuilder()
//                            .header("Cache-Control", "public, max-age=" + MAXAGE)
//                            .removeHeader("Pragma")
//                            .build();
//            }
//      }


//       废弃 此方式只适用 get请求缓存数据
//      /**
//       * @Author: JackL
//       * @params:
//       * @return: 创建时间: 2019/1/9 14:11
//       * 版本:1.0.0
//       * 描述: 为okhttp添加缓存，这里是考虑到服务器不支持缓存时，从而让okhttp支持缓存
//       */
//      private class OfflineCacheInterceptor implements Interceptor {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                  Request request = chain.request();
//                  if (!NetUtil.isNetworkAvailable(MyApplication.getAppContext())) {
//                       request.newBuilder()
//                       .cacheControl(new CacheControl
//                       .Builder()
//                       .maxStale(MAXSTALE,TimeUnit.SECONDS)
//                       .onlyIfCached()
//                       .build());
//                  }
//                  return chain.proceed(request);
//            }
//      }

      /**
       * @Author: JackL
       * @params:
       * @return: 创建时间: 2019/1/9 15:51
       * 版本:1.0.0
       * 描述: 用RXAndroid来统一处理网络请求的线程
       */
      public Observable returnObservable(Observable observable) {

            return observable
                      .retryWhen(new RetryWhenNetworkException())
//              /*异常处理*/
//              .onErrorResumeNext(new ExceptionFunc())
                      /*http请求线程*/
                      .subscribeOn(Schedulers.io())
                      .unsubscribeOn(Schedulers.io())
                      /*回调线程*/
                      .subscribeOn(AndroidSchedulers.mainThread())
                      .observeOn(AndroidSchedulers.mainThread());
      }

      /**
       * @Author: JackL
       * @params:
       * @return: 创建时间: 2019/1/9 15:51
       * 版本:1.0.0
       * 描述:登录
       */
      public Observable login(String username, String password, String platform, String registrationId) {

            return returnObservable(registerApi.login(username, password, platform, registrationId));
      }
}


