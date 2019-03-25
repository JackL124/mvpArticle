package com.jackl.mvparticle.base.toast;

import android.app.Application;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


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
 * 创建时间: 2019/3/15 14:40
 * 版本:1.0.0
 * 描述: BaseToast
 *
*/
public class BaseToast extends Toast {
      // 吐司消息 View
      private TextView mMessageView;

      BaseToast(Application application) {
            super(application);
      }

      @Override
      public void setView(View view) {
            super.setView(view);
            mMessageView = getMessageView(view);
      }

      @Override
      public void setText(CharSequence s) {
            mMessageView.setText(s);
      }

      /**
       * 智能获取用于显示消息的 TextView
       */
      private static TextView getMessageView(View view) {
            TextView messageView;
            if (view instanceof TextView) {
                  messageView = (TextView) view; return messageView;
            } else if (view.findViewById(android.R.id.message) instanceof TextView) {
                  messageView = ((TextView) view.findViewById(android.R.id.message)); return messageView;
            } else if (view instanceof ViewGroup) {
                  if ((messageView = findTextView((ViewGroup) view)) != null) return messageView;
            }
            // 如果设置的布局没有包含一个 TextView 则抛出异常，必须要包含一个 TextView 作为 Message View
            throw new IllegalArgumentException("The layout must contain a TextView");
      }

      /**
       * 递归获取 ViewGroup 中的 TextView 对象
       */
      private static TextView findTextView(ViewGroup group) {
            for (int i = 0; i < group.getChildCount(); i++) {
                  View view = group.getChildAt(i);
                  if ((view instanceof TextView)) {
                        return (TextView) view;
                  } else if (view instanceof ViewGroup) {
                        TextView textView = findTextView((ViewGroup) view);
                        if (textView != null) return textView;
                  }
            }
            return null;
      }
}
