package com.leoncam.sortrforflickr;

import android.app.Application;

import com.leoncam.sortrforflickr.dagger.components.DaggerNetComponent;
import com.leoncam.sortrforflickr.dagger.components.NetComponent;
import com.leoncam.sortrforflickr.dagger.modules.AppModule;
import com.leoncam.sortrforflickr.dagger.modules.NetModule;

public class flickrApp extends Application{
    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("test"))
                .build();
    }

    public NetComponent getNetComponent(){
        return netComponent;
    }
}
