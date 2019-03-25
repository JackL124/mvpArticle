package com.jackl.mvparticle.base.recyclerview.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.chad.library.adapter.base.animation.BaseAnimation;

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
 * 创建时间: 2019/2/12 9:29
 * 版本:1.0.0
 * 描述: CustomAnimation
 *     
*/
public class CustomAnimation implements BaseAnimation {
    @Override
    public Animator[] getAnimators(View view) {
        return new Animator[]{
                ObjectAnimator.ofFloat(view, "scaleY", 0.8f,  1),
                ObjectAnimator.ofFloat(view, "scaleX", 0.8f,  1)
        };
    }
}
