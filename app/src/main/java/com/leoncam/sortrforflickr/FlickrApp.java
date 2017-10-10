package com.leoncam.sortrforflickr;

import android.app.Application;

import com.leoncam.sortrforflickr.dagger.components.ApplicationComponent;
import com.leoncam.sortrforflickr.dagger.components.DaggerApplicationComponent;
import com.leoncam.sortrforflickr.dagger.modules.AppModule;

public class FlickrApp extends Application{
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }
}
