package com.leoncam.sortrforflickr.dagger.modules;

import android.app.Application;
import android.content.Context;

import com.leoncam.sortrforflickr.FlickrApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }
}
