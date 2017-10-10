package com.leoncam.sortrforflickr.dagger.components;

import com.leoncam.sortrforflickr.FlickrApp;
import com.leoncam.sortrforflickr.dagger.modules.AppModule;
import com.leoncam.sortrforflickr.dagger.modules.PresenterModule;
import com.leoncam.sortrforflickr.dagger.modules.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {AppModule.class, ServiceModule.class}
)
public interface ApplicationComponent {
    void inject(FlickrApp flickrApp);

    PresenterComponent plus(PresenterModule presenterModule);
}
