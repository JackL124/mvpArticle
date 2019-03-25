package com.jackl.mvparticle.module.example;

import com.jackl.mvparticle.inject.PerActivity;
import com.jackl.mvparticle.presenter.example.IExampleThreePresenter;
import com.jackl.mvparticle.presenter.example.impl.ExampleThreePresenter;
import com.jackl.mvparticle.view.example.example_three.IExampleThree;
import dagger.Module;
import dagger.Provides;


@Module
public class ExampleThreeModule {
      private IExampleThree mView;
      public ExampleThreeModule(IExampleThree mView) {
            this.mView=mView;

      }

      @PerActivity
      @Provides
      public IExampleThreePresenter providesPresenter(){
            return new ExampleThreePresenter(mView);
      }
}

