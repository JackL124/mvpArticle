package com.jackl.mvparticle.base.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jackl.mvparticle.R;
import java.util.ArrayList;


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
 * 创建时间: 2019/1/10 16:04
 * 版本:1.0.0
 * 描述: LoadLayout
 *     
*/
public class LoadStatusLayout extends RelativeLayout {
    private static final RelativeLayout.LayoutParams DEFAULT_LAYOUT_PARAMS =
              new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);

    public static final int STATUS_CONTENT = 0x00;
    public static final int STATUS_LOADING = 0x01;
    public static final int STATUS_EMPTY = 0x02;
    public static final int STATUS_NETERROR = 0x03;
    public static final int STATUS_DATAERROR = 0x04;
    public static final int STATUS_UNKNOWNERROR = 0x05;
    private static final int NULL_RESOURCE_ID = -1;

    private View mLoadingView;
    private View mEmptyView;
    private View mNetErrorView;
    private View mDataErrorView;
    private View mUnknownErrorView;
    private View mContentView;

    private int mLoadingViewResId;
    private int mEmptyViewResId;
    private int mNetErrorViewResId;
    private int mDataErrorViewResId;
    private int mUnknownErrorViewResId;
    private int mContentViewResId;

    private int mViewStatus = -1;
    private final LayoutInflater mInflater;
    private OnClickListener mOnRetryClickListener;
    private OnClickListener onNetClickListener;
    private OnViewStatusChangeListener mViewStatusListener;

    private final ArrayList<Integer> mOtherIds = new ArrayList<>();
    private int oldViewId=-1;

    public LoadStatusLayout(Context context) {
        this(context, null);
    }

    public LoadStatusLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadStatusLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LoadStatusLayout, defStyleAttr, 0);
        mLoadingViewResId = a.getResourceId(R.styleable.LoadStatusLayout_loadingView, R.layout.layout_loading_view);
        mEmptyViewResId = a.getResourceId(R.styleable.LoadStatusLayout_emptyView, R.layout.layout_empty_view);
        mNetErrorViewResId = a.getResourceId(R.styleable.LoadStatusLayout_netErrorView, R.layout.layout_neterror_view);
        mDataErrorViewResId = a.getResourceId(R.styleable.LoadStatusLayout_dataErrorView, R.layout.layout_dataerror_view);
        mUnknownErrorViewResId = a.getResourceId(R.styleable.LoadStatusLayout_unknownErrorView, R.layout.layout_unknownerror_view);
        mContentViewResId = a.getResourceId(R.styleable.LoadStatusLayout_contentView, NULL_RESOURCE_ID);
        a.recycle();
        mInflater = LayoutInflater.from(getContext());
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        showContent();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clear(mLoadingView,mEmptyView,mNetErrorView, mDataErrorView, mUnknownErrorView,mContentView);
        if (!mOtherIds.isEmpty()) {
            mOtherIds.clear();
        }
        if (null != mOnRetryClickListener) {
            mOnRetryClickListener = null;
        }

        if (null != onNetClickListener) {
            onNetClickListener = null;
        }


        if (null != mViewStatusListener) {
            mViewStatusListener = null;
        }
    }

    /**
     * 获取当前状态
     *
     * @return 视图状态
     */
    public int getViewStatus() {
        return mViewStatus;
    }

    /**
     * 设置重试点击事件
     *
     * @param onRetryClickListener 重试点击事件
     */
    public void setOnRetryClickListener(OnClickListener onRetryClickListener) {
        this.mOnRetryClickListener = onRetryClickListener;
    }

    public void setOnNetClickListener(OnClickListener onNetClickListener) {
        this.onNetClickListener = onNetClickListener;
    }



    /**
     * 显示加载中视图
     */
    public final void showLoading() {
        showLoading(mLoadingViewResId, DEFAULT_LAYOUT_PARAMS);
    }

    /**
     * 显示加载中视图
     *
     * @param layoutId     自定义布局文件
     * @param layoutParams 布局参数
     */
    public final void showLoading(int layoutId, ViewGroup.LayoutParams layoutParams) {
        showLoading(null == mLoadingView ? inflateView(layoutId) : mLoadingView, layoutParams);
    }

    /**
     * 显示加载中视图
     *
     * @param view         自定义视图
     * @param layoutParams 布局参数
     */
    public final void showLoading(View view, ViewGroup.LayoutParams layoutParams) {
        checkNull(view, "Loading view is null.");
        checkNull(layoutParams, "Layout params is null.");
        changeViewStatus(STATUS_LOADING);
        if (null == mLoadingView) {
            mLoadingView = view;
            mOtherIds.add(mLoadingView.getId());
            addView(mLoadingView, 0, layoutParams);
        }
        showViewById(mLoadingView.getId());
        oldViewId = mLoadingView.getId();
    }


    /**
     * 显示网络错误视图
     */
    public final void showNetError(String message) {
        showNetError(mNetErrorViewResId, DEFAULT_LAYOUT_PARAMS,message);
    }

    /**
     * 显示网络错误视图
     *
     * @param layoutId     自定义布局文件
     * @param layoutParams 布局参数
     */
    public final void showNetError(int layoutId, ViewGroup.LayoutParams layoutParams,String message) {
        showNetError(null == mNetErrorView ? inflateView(layoutId) : mNetErrorView, layoutParams,message);
    }


    /**
     * 显示网络错误视图
     *
     * @param view         自定义视图
     * @param layoutParams 布局参数
     */
    public final void showNetError(View view, ViewGroup.LayoutParams layoutParams,String message) {
        checkNull(view, "Error view is null.");
        checkNull(layoutParams, "Layout params is null.");
        changeViewStatus(STATUS_NETERROR);
        if (null == mNetErrorView) {
            mNetErrorView = view;
            View netErrorView = mNetErrorView.findViewById(R.id.netError_view);
            if (null != onNetClickListener && null != netErrorView) {
                netErrorView.setOnClickListener(onNetClickListener);
            }
            TextView netErrorTextView = mNetErrorView.findViewById(R.id.netError_view_tv);
            netErrorTextView.setText(message);
            mOtherIds.add(mNetErrorView.getId());
            addView(mNetErrorView, 0, layoutParams);
        }
        showViewById(mNetErrorView.getId());
        oldViewId = mNetErrorView.getId();
    }

    /**
     * 显示数据错误视图
     */
    public final void showDataError(String message) {
        showDataError(mDataErrorViewResId, DEFAULT_LAYOUT_PARAMS,message);
    }

    /**
     * 显示数据错误视图
     *
     * @param layoutId     自定义布局文件
     * @param layoutParams 布局参数
     */
    public final void showDataError(int layoutId, ViewGroup.LayoutParams layoutParams,String message) {
        showDataError(null == mDataErrorView ? inflateView(layoutId) : mDataErrorView, layoutParams,message);
    }

    /**
     * 显示数据错误视图
     *
     * @param view         自定义视图
     * @param layoutParams 布局参数
     */
    public final void showDataError(View view, ViewGroup.LayoutParams layoutParams,String message) {
        checkNull(view, "No network view is null.");
        checkNull(layoutParams, "Layout params is null.");
        changeViewStatus(STATUS_DATAERROR);
        if (null == mDataErrorView) {
            mDataErrorView = view;
            View dataErrorView = mDataErrorView.findViewById(R.id.dataError);
            if (null != mOnRetryClickListener && null != dataErrorView) {
                dataErrorView.setOnClickListener(mOnRetryClickListener);
            }
            TextView dataErrorTextView = mDataErrorView.findViewById(R.id.data_error_view_tv);
            dataErrorTextView.setText(message);
            mOtherIds.add(mDataErrorView.getId());
            addView(mDataErrorView, 0, layoutParams);
        }
        showViewById(mDataErrorView.getId());
        oldViewId = mDataErrorView.getId();
    }


    /**
     * 显示未知错误视图
     */
    public final void showUnknownError(String message) {
        showUnknownError(mUnknownErrorViewResId, DEFAULT_LAYOUT_PARAMS,message);
    }

    /**
     * 显示未知错误视图
     *
     * @param layoutId     自定义布局文件
     * @param layoutParams 布局参数
     */
    public final void showUnknownError(int layoutId, ViewGroup.LayoutParams layoutParams,String message) {
        showUnknownError(null == mUnknownErrorView ? inflateView(layoutId) : mUnknownErrorView, layoutParams,message);
    }

    /**
     * 显示未知错误视图
     *
     * @param view         自定义视图
     * @param layoutParams 布局参数
     */
    public final void showUnknownError(View view, ViewGroup.LayoutParams layoutParams,String message) {
        checkNull(view, "No network view is null.");
        checkNull(layoutParams, "Layout params is null.");
        changeViewStatus(STATUS_UNKNOWNERROR);
        if (null == mUnknownErrorView) {
            mUnknownErrorView = view;
            View unknownErrorView = mUnknownErrorView.findViewById(R.id.unknownerrorView);
            if (null != mOnRetryClickListener && null != unknownErrorView) {
                unknownErrorView.setOnClickListener(mOnRetryClickListener);
            }
            TextView unknownErrorTextView = mUnknownErrorView.findViewById(R.id.unknownerrorView_tv);
            unknownErrorTextView.setText(message);
            mOtherIds.add(mUnknownErrorView.getId());
            addView(mUnknownErrorView, 0, layoutParams);
        }
        showViewById(mUnknownErrorView.getId());
    }


    /**
     * 显示空视图
     */
    public final void showEmpty() {
        showEmpty(mEmptyViewResId, DEFAULT_LAYOUT_PARAMS);
    }

    /**
     * 显示空视图
     *
     * @param layoutId     自定义布局文件
     * @param layoutParams 布局参数
     */
    public final void showEmpty(int layoutId, ViewGroup.LayoutParams layoutParams) {
        showEmpty(null == mEmptyView ? inflateView(layoutId) : mEmptyView, layoutParams);
    }

    /**
     * 显示空视图
     *
     * @param view         自定义视图
     * @param layoutParams 布局参数
     */
    public final void showEmpty(View view, ViewGroup.LayoutParams layoutParams) {
        checkNull(view, "Empty view is null.");
        checkNull(layoutParams, "Layout params is null.");
        changeViewStatus(STATUS_EMPTY);
        if (null == mEmptyView) {
            mEmptyView = view;
            View emptyView = mEmptyView.findViewById(R.id.emptyView);
            if (null != mOnRetryClickListener && null != emptyView) {
                emptyView.setOnClickListener(mOnRetryClickListener);
            }
            mOtherIds.add(mEmptyView.getId());
            addView(mEmptyView, 0, layoutParams);
        }
        showViewById(mEmptyView.getId());
        oldViewId = mLoadingView.getId();
    }


    /**
     * 显示内容视图
     */
    public final void showContent() {
        changeViewStatus(STATUS_CONTENT);
        if (null == mContentView && mContentViewResId != NULL_RESOURCE_ID) {
            mContentView = mInflater.inflate(mContentViewResId, null);
            addView(mContentView, 0, DEFAULT_LAYOUT_PARAMS);
        }
            showContentView();
    }



    private View inflateView(int layoutId) {
        return mInflater.inflate(layoutId, null);
    }

    private void showContentView() {
        final int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if(view!=null&&mOtherIds.contains(view.getId())){
                view.setVisibility(GONE);
            }else{
                viewContentToUp(view,mLoadingView);
            }
        }

    }

    private void showViewById(int viewId) {
        final int childCount = getChildCount();

        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if(view!=null&&view.getId()==viewId){
                viewToUp(view);
            }else{
                view.setVisibility(GONE);
            }
        }
    }


    public static void viewContentToUp(final View view, final View mLoadingView) {
        AnimationSet animationSet = new AnimationSet(false);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        animationSet.addAnimation(alphaAnimation);
        view.startAnimation(animationSet);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                view.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(mLoadingView!=null){
                    mLoadingView.setVisibility(GONE);
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    public static void viewToUp(final View view) {
        AnimationSet animationSet = new AnimationSet(false);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        animationSet.addAnimation(alphaAnimation);
        view.startAnimation(animationSet);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                view.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void checkNull(Object object, String hint) {
        if (null == object) {
            throw new NullPointerException(hint);
        }
    }

    private void clear(View... views) {
        if (null == views) {
            return;
        }
        try {
            for (View view : views) {
                if (null != view) {
                    removeView(view);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 视图状态改变接口
     */
    public interface OnViewStatusChangeListener {

        /**
         * 视图状态改变时回调
         * @param oldViewStatus 之前的视图状态
         * @param newViewStatus 新的视图状态
         */
        void onChange(int oldViewStatus, int newViewStatus);
    }

    /**
     * 设置视图状态改变监听事件
     *
     * @param onViewStatusChangeListener 视图状态改变监听事件
     */
    public void setOnViewStatusChangeListener(OnViewStatusChangeListener onViewStatusChangeListener) {
        this.mViewStatusListener = onViewStatusChangeListener;
    }

    /**
     * 改变视图状态
     *
     * @param newViewStatus 新的视图状态
     */
    private void changeViewStatus(int newViewStatus) {
        if (mViewStatus == newViewStatus) {
            return;
        }
        if (null != mViewStatusListener) {
            mViewStatusListener.onChange(mViewStatus, newViewStatus);
        }
        mViewStatus = newViewStatus;
    }
}
