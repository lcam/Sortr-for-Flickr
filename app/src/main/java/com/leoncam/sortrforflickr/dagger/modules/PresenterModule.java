package com.leoncam.sortrforflickr.dagger.modules;

import com.leoncam.sortrforflickr.presenter.GridPresenter;
import com.leoncam.sortrforflickr.services.ServiceGenerator;
import com.leoncam.sortrforflickr.view.MainActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @Provides
    @Singleton
    public GridPresenter provideGridPresenter(MainActivity view, ServiceGenerator service){
        return new GridPresenter(view, service);
    }
}
