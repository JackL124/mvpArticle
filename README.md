
# mvpArticle
Dagger2 + RxAndroid + MVP + Okhttp3 + Retrofit + Greendao + RxBus + SwipeBack+BaseRecyclerViewAdapterHelper


## Demo展示

##### [Demo apk下载](https://github.com/JackL124/mvpArticle/blob/master/apk/mvparticle.apk)

![enter image description here](https://github.com/JackL124/MvpArticle/blob/master/screenshot/example.gif?raw=true)

## 一、功能介绍

 1. **Dagger2+MVP设计模式减轻View层代码复杂程度以及耦合程度**

 2. **配合Rxjava+Retrofit+Okhttp3响应式编程，使得代码更为简洁，层次更为清晰**

 3. **配合自定义拦截器拦截器方式，配合DiskLruCache使Okhttp支持Post表单请求离线缓存数据**

 4. **配合自定义拦截器实现全局异常拦截、处理并与基类页面状态进行绑定，简化代码、缩短开发周期**

 5. **在[Fragmentation](https://github.com/YoKeyword/Fragmentation)基础上增加了fragment/activity之间以及activity之间仿IOS视差效果左侧滑动关闭页面，同时兼容了[Fragmentation](https://github.com/YoKeyword/Fragmentation) 强大的Fragment处理、管理机制，降低了activity+fragment App的开发难度**

6. **自定义toast，android7.0以上没有开启通知权限也能够显示**




## 二、案例讲解

 - **增加activity栈结构，配合Fragmentation中fragment栈结构，处理activity->fragment/fragment->activity情况下视差效果滑动动画**


![enter image description here](https://github.com/JackL124/MvpArticle/blob/master/screenshot/example2.gif?raw=true)                    ![enter image description here](https://raw.githubusercontent.com/JackL124/MvpArticle/master/screenshot/example1.gif)

 - **加载loading Dialog效果页面使用**
 
   1.**继承BaseLoadActivity/BaseLoadFragment**
   
   2.**activity/fragment接口继承自IBaseLoad**
   
   3.**使用BaseLoadSubscriber**
   
   4.**如无需动画则 BaseLoadSubscriber第三个参数传递false**
   
      ```java
		subscribe(new BaseLoadSubscriber(new ResponseListener<List<LiveListItemBean>>(){  
		      @Override  
		public void onNext(List<LiveListItemBean> liveListItemBeanList) {  
            mView.loadLiveListDetial(liveListItemBeanList);  
			 }  
  
		      @Override  
		public void onError(Throwable e) {  
            super.onError(e);  
			  mView.onNetError();  
			}  
		},mView,false)); 
		```


![enter image description here](https://github.com/JackL124/MvpArticle/blob/master/screenshot/example3.gif?raw=true)

 - **加载异常空白页面使用**
 
   1.**继承BaseStatusActivity/BaseStatusFragment**
   
   2.**activity/fragment接口继承自IBaseStatus**
   
   3.**使用LoadStatusLayout 作为页面布局容器**
   
   4.**使用BaseStatusSubscriber** 
   
   
     ``` xml
	<com.jackl.mvparticle.base.widget.LoadStatusLayout  
	  android:id="@+id/load_status_view"  
	  android:layout_width="match_parent"  
	  android:layout_height="match_parent"  
	  android:background="@color/colorWhite"  
	  app:contentView="@layout/view_liveplay" >
	  
  
  ![enter image description here](https://github.com/JackL124/MvpArticle/blob/master/screenshot/example4.gif?raw=true)
  
  - **post请求缓存数据**

		只需通过配置注解@Headers，就可使Okhttp Post支持数据离线缓存 
		
	``` java
		 
		@Headers({CacheHeaders.NORMAL})  
		@POST("/login")  
		@FormUrlEncoded
		Observable<BaseRegisterResult<LoginBean>> login(@Field("username") String username,  
							       @Field("password") String password,  
						  	      @Field("platform") String platform,  
							       @Field("registrationId") String registrationId);
	```
    
    

![enter image description here](https://github.com/JackL124/MvpArticle/blob/master/screenshot/example5.gif?raw=true)



## thanks
-   dagger2
-   rxjava
-   okhttp3
-   DiskLruCache
-   BaseRecyclerViewAdapterHelper
-   greendao
-   Fragmentation
-   butterknife
-   eventBus
-   glide
-   leakcanary
-   stetho
-  AVLoadingIndicatorView
-  statusbarutil
- MagicIndicator

## About Me
**Email** : [13387504213@163.com](mailto:13387504213@163.com)

如若您在使用过程中遇到任何问题，欢迎及时反馈bug，我会及时跟进。项目编写实属不易，如果您觉得还不错 ，一定要star fork哦。


