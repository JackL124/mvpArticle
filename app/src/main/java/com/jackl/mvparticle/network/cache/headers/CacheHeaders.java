package com.jackl.mvparticle.network.cache.headers;

public class CacheHeaders {

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
       * 创建时间: 2019/2/15 16:45
       * 版本:1.0.0
       * 描述: CacheHeaders 自定义缓存头
       *
      */
      /*是否缓存*/
      public static final String NORMAL = "cache:true";
      /*表示数据内容只能被储存到私有的cache，仅对某个用户有效，不能共享*/
      public static final String PRIVATE = "Cache-Control:private";
      /*表示返回数据的过期时间*/
      public static final String MAX_AGE = "Cache-Control:max-age";
     /*表示可以缓存，但是只有在跟WEB服务器验证了其有效后，才能返回给客户端，触发对比缓存*/
      public static final String NO_CACHE = "Cache-Control:no-cache";
      /*表示数据内容都可以被储存起来，就连有密码保护的网页也储存，安全性很低*/
      public static final String PUBLIC = "Cache-Control:public";
      /*表示请求和响应都禁止被缓存，强制缓存，对比缓存都不会触发*/
      public static final String NO_STORE = "Cache-Control:no-store";
}
