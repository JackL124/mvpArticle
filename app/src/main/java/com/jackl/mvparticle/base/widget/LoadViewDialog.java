package com.jackl.mvparticle.base.widget;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.jackl.mvparticle.R;
import com.wang.avi.AVLoadingIndicatorView;

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
 * 创建时间: 2019/2/19 15:40
 * 版本:1.0.0
 * 描述: LoadViewDialog
 *
*/
public class LoadViewDialog extends DialogFragment {
      private View rootView;
      private AVLoadingIndicatorView loading_ndicator;
      private static volatile LoadViewDialog instance = null;

      @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
      @Override
      public void onStart() {
            super.onStart();
            Window window = getDialog().getWindow();
            WindowManager.LayoutParams params = window.getAttributes();
            params.gravity = Gravity.CENTER;
            params.width = WindowManager.LayoutParams.WRAP_CONTENT;
            params.height=WindowManager.LayoutParams.WRAP_CONTENT;
            window.setAttributes(params);
            View decorView = window.getDecorView();
            decorView.setBackground(new ColorDrawable(Color.TRANSPARENT));
      }

      @Override
      public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
            getDialog().setCanceledOnTouchOutside(false);
            rootView = inflater.inflate(R.layout.layout_loadview, container, false);
            return rootView;
      }

      @Override
      public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            loading_ndicator = (AVLoadingIndicatorView) view.findViewById(R.id.loading_ndicator);
      }

      public void startAnim(){
            loading_ndicator.show();
      }

      public void stopAnim(){
            loading_ndicator.hide();
      }

      @Override
      public void onDestroy() {
            super.onDestroy();

      }
}
