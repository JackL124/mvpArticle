package com.jackl.mvparticle.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import java.util.Stack;

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
 * 创建时间: 2019/1/10 15:29
 * 版本:1.0.0
 * 描述: AppTaskManager
 *
*/

public class AppTaskManager {
      private static Stack<AppCompatActivity > activityStack = new Stack<AppCompatActivity >();

      /**
       * 添加Activity到堆栈
       */
      public static void addActivity(AppCompatActivity  activity) {
            activityStack.push(activity);
      }

      /**
       * 获取当前Activity（堆栈中最后一个压入的）
       */
      public static AppCompatActivity  currentActivity() {
            return activityStack.lastElement();
      }

      /**
       * 获取倒数第二个Activity
       */
      public static AppCompatActivity getSecondlastActivity() {

            if (activityStack.size() > 1) {
                  return activityStack.get(activityStack.size() - 2);
            } else {
                  return null;
            }
      }

      /**
       * 结束当前Activity（堆栈中最后一个压入的）
       */
      public static void finishCurrentActivity() {
            Activity activity = activityStack.pop();
            activity.finish();
      }

      /**
       * 结束指定的Activity
       */
      public static void finishActivity(Activity activity) {
            if (activity != null) {
                  activityStack.remove(activity);
                  if (!activity.isFinishing()) {
                        activity.finish();
                  }
            }
      }

      /**
       * 结束指定类名的Activity
       */
      public static void finishActivity(Class<?> cls) {
            for (Activity activity : activityStack) {
                  if (activity.getClass().equals(cls)) {
                        finishActivity(activity);
                  }
            }
      }

      /**
       * 结束所有Activity
       */
      public static void finishAllActivity() {
            for (Activity activity : activityStack) {
                  if (activity != null) {
                        activity.finish();
                  }
            }
            activityStack.clear();
      }

      /**
       * 退出应用程序
       */
      public static void AppExit(Context context) {
            try {
                  finishAllActivity();
                  ActivityManager manager = (ActivityManager) context
                            .getSystemService(Context.ACTIVITY_SERVICE);
                  manager.killBackgroundProcesses(context.getPackageName());
                  System.exit(0);
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }
}
