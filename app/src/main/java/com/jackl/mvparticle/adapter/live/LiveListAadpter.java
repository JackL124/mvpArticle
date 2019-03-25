package com.jackl.mvparticle.adapter.live;


import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jackl.mvparticle.R;
import com.jackl.mvparticle.entity.live.LiveListItemBean;
import java.util.List;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

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
 * 创建时间: 2019/3/14 13:12
 * 版本:1.0.0
 * 描述: LiveListAadpter
 *
*/

public class LiveListAadpter extends BaseQuickAdapter <LiveListItemBean, BaseViewHolder> {

      public LiveListAadpter(List<LiveListItemBean> data) {
            super(R.layout.item_live_list,data);
      }

      @Override
      protected void convert(BaseViewHolder helper, LiveListItemBean item) {

            helper.setText(R.id.tv_roomname, item.getLive_title())//房间名称
                      .setText(R.id.tv_nickname, item.getLive_nickname())//主播昵称
                      .setText(R.id.tv_online, String.valueOf(item.getLive_online()))//在线人数
                      .addOnClickListener(R.id.cardview);//添加子Item点击监听，在UI中实现回调接口

            Glide.with(mContext)//直播房间截图
                      .load(item.getLive_img())
                      .crossFade()
                      .centerCrop()
                      .into((ImageView) helper.getView(R.id.iv_roomsrc));

            Glide.with(mContext)//主播头像
                      .load(item.getLive_userimg())
                      .placeholder(R.drawable.ic_avatar_default)
                      .bitmapTransform(new CropCircleTransformation(mContext))
                      .into((ImageView) helper.getView(R.id.iv_avatar));

      }
}
