package com.jackl.mvparticle.base.recyclerview;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.jackl.mvparticle.R;

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
 * 创建时间: 2019/3/11 17:50
 * 版本:1.0.0
 * 描述: CustomLoadMoreView
 *
*/

public final class CustomLoadMoreView extends LoadMoreView {

    @Override
    public int getLayoutId() {
        return R.layout.layout_loadmore;
    }

    /**
     * 如果返回true，数据全部加载完毕后会隐藏加载更多
     * 如果返回false，数据全部加载完毕后会显示getLoadEndViewId()布局
     */
    @Override
    public boolean isLoadEndGone() {
        return false;
    }


    @Override
    protected int getLoadingViewId() {
        return R.id.loading;
    }

    @Override
    protected int getLoadFailViewId() {
        return R.id.tv_fail;
    }

    @Override
    protected int getLoadEndViewId() {
        return R.id.tv_end;
    }
}