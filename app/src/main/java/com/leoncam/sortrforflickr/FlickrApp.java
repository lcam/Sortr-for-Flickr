package com.leoncam.sortrforflickr;

import android.app.Application;

import com.leoncam.sortrforflickr.dagger.components.AppComponent;
import com.leoncam.sortrforflickr.dagger.components.DaggerAppComponent;

public class FlickrApp extends Application{
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
