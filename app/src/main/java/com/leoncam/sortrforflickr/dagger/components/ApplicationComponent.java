package com.leoncam.sortrforflickr.dagger.components;

import com.leoncam.sortrforflickr.FlickrApp;
import com.leoncam.sortrforflickr.dagger.modules.AppModule;
import com.leoncam.sortrforflickr.dagger.modules.ServiceModule;
import com.leoncam.sortrforflickr.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {AppModule.class, ServiceModule.class }
)
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
