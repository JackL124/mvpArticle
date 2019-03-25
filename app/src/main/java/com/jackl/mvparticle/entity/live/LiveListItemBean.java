package com.jackl.mvparticle.entity.live;

import java.util.List;

public class LiveListItemBean {

      /**
       * enable : 1
       * game_type : lol
       * live_id : 177
       * live_img : http://snap.quanmin.tv/177-1523588791-34.jpg?imageView2/w/290
       * live_name : quanmin
       * live_nickname : RIOT拳头游戏
       * live_online : 21186
       * live_title : 2017全明星赛重播
       * live_type : quanmin
       * live_userimg : http://a.img.shouyintv.cn/E6It201-normal
       * show_type : native
       */

      private int enable;
      private String game_type;
      private String live_id;
      private String live_img;
      private String live_name;
      private String live_nickname;
      private int live_online;
      private String live_title;
      private String live_type;
      private String live_userimg;
      private String show_type;

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

      public String getShow_type() {
            return show_type;
      }

      public void setShow_type(String show_type) {
            this.show_type = show_type;
      }

      @Override
      public String toString() {
            return "ResultBean{" +
                      "enable=" + enable +
                      ", game_type='" + game_type + '\'' +
                      ", live_id='" + live_id + '\'' +
                      ", live_img='" + live_img + '\'' +
                      ", live_name='" + live_name + '\'' +
                      ", live_nickname='" + live_nickname + '\'' +
                      ", live_online=" + live_online +
                      ", live_title='" + live_title + '\'' +
                      ", live_type='" + live_type + '\'' +
                      ", live_userimg='" + live_userimg + '\'' +
                      ", show_type='" + show_type + '\'' +
                      '}';
      }
}


