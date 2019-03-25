package com.jackl.mvparticle.entity.live;

import java.util.List;

public class LiveDetailBean {

      /**
       * enable : 1
       * game_type : lol
       * is_followed : 0
       * live_id : 1956376362
       * live_img : http://snap.quanmin.tv/1956376362-1523588791-807.jpg?imageView2/w/290
       * live_name : quanmin
       * live_nickname : 肖邦C
       * live_online : 15880
       * live_title : 乱玩!不是主播本人 本人有事
       * live_type : quanmin
       * live_userimg : http://a.img.shouyintv.cn/hey1401-normal
       * stream_list : [{"type":"高清","url":"http://liveal.quanmin.tv/live/1956376362.flv"}]
       */

      private int enable;
      private String game_type;
      private int is_followed;
      private String live_id;
      private String live_img;
      private String live_name;
      private String live_nickname;
      private int live_online;
      private String live_title;
      private String live_type;
      private String live_userimg;
      private List<StreamListBean> stream_list;

      public int getEnable() {
            return enable;
      }

      public void setEnable(int enable) {
            this.enable = enable;
      }

      public String getGame_type() {
            return game_type;
      }

      public void setGame_type(String game_type) {
            this.game_type = game_type;
      }

      public int getIs_followed() {
            return is_followed;
      }

      public void setIs_followed(int is_followed) {
            this.is_followed = is_followed;
      }

      public String getLive_id() {
            return live_id;
      }

      public void setLive_id(String live_id) {
            this.live_id = live_id;
      }

      public String getLive_img() {
            return live_img;
      }

      public void setLive_img(String live_img) {
            this.live_img = live_img;
      }

      public String getLive_name() {
            return live_name;
      }

      public void setLive_name(String live_name) {
            this.live_name = live_name;
      }

      public String getLive_nickname() {
            return live_nickname;
      }

      public void setLive_nickname(String live_nickname) {
            this.live_nickname = live_nickname;
      }

      public int getLive_online() {
            return live_online;
      }

      public void setLive_online(int live_online) {
            this.live_online = live_online;
      }

      public String getLive_title() {
            return live_title;
      }

      public void setLive_title(String live_title) {
            this.live_title = live_title;
      }

      public String getLive_type() {
            return live_type;
      }

      public void setLive_type(String live_type) {
            this.live_type = live_type;
      }

      public String getLive_userimg() {
            return live_userimg;
      }

      public void setLive_userimg(String live_userimg) {
            this.live_userimg = live_userimg;
      }

      public List<StreamListBean> getStream_list() {
            return stream_list;
      }

      public void setStream_list(List<StreamListBean> stream_list) {
            this.stream_list = stream_list;
      }

      public static class StreamListBean {
            /**
             * type : 高清
             * url : http://liveal.quanmin.tv/live/1956376362.flv
             */

            private String type;
            private String url;

            public String getType() {
                  return type;
            }

            public void setType(String type) {
                  this.type = type;
            }

            public String getUrl() {
                  return url;
            }

            public void setUrl(String url) {
                  this.url = url;
            }
      }
}

