package com.leoncam.sortrforflickr.dagger.modules;

import com.leoncam.sortrforflickr.presenter.GridPresenter;
import com.leoncam.sortrforflickr.services.ServiceGenerator;
import com.leoncam.sortrforflickr.view.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    MainActivity activity;
    ServiceGenerator service;

    public PresenterModule(MainActivity activity){
        this.activity = activity;
    }

    @Provides
    GridPresenter provideGridPresenter(ServiceGenerator service){
        return new GridPresenter(activity, service);
    }
}
