package com.jackl.mvparticle.base.swipeback.listener;

import android.support.annotation.FloatRange;
import android.view.View;
import com.jackl.mvparticle.base.swipeback.widget.SwipeBackLayout;

public interface ISwipeBackFragment {

      View attachToSwipeBack(View view);

      SwipeBackLayout getSwipeBackLayout();

      void setSwipeBackEnable(boolean enable);

      void setEdgeLevel(SwipeBackLayout.EdgeLevel edgeLevel);

      void setEdgeLevel(int widthPixel);

      /**
       * Set the offset of the parallax slip.
       */
      void setParallaxOffset(@FloatRange(from = 0.0f, to = 1.0f) float offset);
}
