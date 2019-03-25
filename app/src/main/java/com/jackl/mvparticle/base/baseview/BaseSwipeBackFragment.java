package com.jackl.mvparticle.base.baseview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jackl.mvparticle.base.MyApplication;
import com.jackl.mvparticle.base.swipeback.SwipeBackFragmentDelegate;
import com.jackl.mvparticle.base.swipeback.listener.ISwipeBackFragment;
import com.jackl.mvparticle.base.swipeback.widget.SwipeBackLayout;
import com.jackl.mvparticle.inject.component.AppComponent;
import butterknife.ButterKnife;
import butterknife.Unbinder;

 public abstract class BaseSwipeBackFragment extends BaseFragment implements ISwipeBackFragment{
      private Unbinder bind;
      private View mRootView;
      protected Context mContext;
      final SwipeBackFragmentDelegate mDelegate = new SwipeBackFragmentDelegate(this);
      @Override
      public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mContext = getActivity();
            mDelegate.onCreate(savedInstanceState);
            setParallaxOffset(0.5f);
      }

      @Nullable
      @Override
      public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            if (mRootView == null) {
                  mRootView = inflater.inflate(getContentView(), null);
                  bind = ButterKnife.bind(this, mRootView);
                  initInjector();
                  initView();
            }
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                  parent.removeView(mRootView);
            }
            return attachToSwipeBack(mRootView);
      }

      @Override
      public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            mDelegate.onViewCreated(view, savedInstanceState);
      }

      @Override
      public View attachToSwipeBack(View view) {
            return mDelegate.attachToSwipeBack(view);
      }

      @Override
      public void onHiddenChanged(boolean hidden) {
            super.onHiddenChanged(hidden);
            mDelegate.onHiddenChanged(hidden);
      }

      @Override
      public void onDestroyView() {
            mDelegate.onDestroyView();
            super.onDestroyView();
      }

      @Override
      public void onDestroy() {
            super.onDestroy();
            if(bind!=null){
                  bind.unbind();
            }
      }



      /**
       * 设置layout布局
       */
      protected abstract int getContentView();

      /**
       * Dagger 注入
       */
      protected abstract void initInjector();

      /**
       * 页面初始化工作
       */
      protected abstract void initView();


      public SwipeBackLayout getSwipeBackLayout() {
            return mDelegate.getSwipeBackLayout();
      }


      /**
       * 是否可滑动
       *
       * @param enable
       */
      public void setSwipeBackEnable(boolean enable) {
            mDelegate.setSwipeBackEnable(enable);
      }

      @Override
      public void setEdgeLevel(SwipeBackLayout.EdgeLevel edgeLevel) {
            mDelegate.setEdgeLevel(edgeLevel);
      }

      @Override
      public void setEdgeLevel(int widthPixel) {
            mDelegate.setEdgeLevel(widthPixel);
      }

      /**
       * Set the offset of the parallax slip.
       */
      public void setParallaxOffset(@FloatRange(from = 0.0f, to = 1.0f) float offset) {
            mDelegate.setParallaxOffset(offset);
      }

      protected AppComponent getAppComponent() {
            return MyApplication.getAppComponent();
      }

      /**
       * 初始化 Toolbar
       *
       * @param toolbar
       * @param title
       */
      protected void initToolBar(Toolbar toolbar, String title) {
            ((BaseSwipeBackActivity)getActivity()).initToolBar(toolbar, title);
      }
}
