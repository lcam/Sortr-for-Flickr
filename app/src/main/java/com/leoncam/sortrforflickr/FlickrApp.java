package com.leoncam.sortrforflickr;

import android.app.Application;

import com.leoncam.sortrforflickr.dagger.components.DaggerPresenterComponent;
import com.leoncam.sortrforflickr.dagger.components.PresenterComponent;
import com.leoncam.sortrforflickr.dagger.modules.AppModule;
import com.leoncam.sortrforflickr.dagger.modules.PresenterModule;

public class FlickrApp extends Application{
    private PresenterComponent presenterComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        presenterComponent = DaggerPresenterComponent.builder()
                .appModule(new AppModule(this))
                .presenterModule(new PresenterModule())
                .build();
    }

    public PresenterComponent getPresenterComponent(){
        return presenterComponent;
    }
}
