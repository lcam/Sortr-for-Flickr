package com.leoncam.sortrforflickr;

import android.app.Application;

import com.leoncam.sortrforflickr.dagger.components.DaggerPresenterComponent;
import com.leoncam.sortrforflickr.dagger.components.PresenterComponent;
import com.leoncam.sortrforflickr.dagger.modules.AppModule;
import com.leoncam.sortrforflickr.dagger.modules.ServiceModule;

public class flickrApp extends Application{
    private PresenterComponent presenterComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        presenterComponent = DaggerPresenterComponent.builder()
                .appModule(new AppModule(this))
                .serviceModule(new ServiceModule())
                .build();
    }

    public PresenterComponent getPresenterComponent(){
        return presenterComponent;
    }
}
