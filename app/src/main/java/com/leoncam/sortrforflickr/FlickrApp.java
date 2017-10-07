package com.leoncam.sortrforflickr;

import android.app.Application;

import com.leoncam.sortrforflickr.dagger.components.ApplicationComponent;
import com.leoncam.sortrforflickr.dagger.components.DaggerApplicationComponent;
import com.leoncam.sortrforflickr.dagger.modules.AppModule;
import com.leoncam.sortrforflickr.dagger.modules.PresenterModule;
import com.leoncam.sortrforflickr.dagger.modules.ServiceModule;

public class FlickrApp extends Application{
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .serviceModule(new ServiceModule())
                .build();
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }
}
