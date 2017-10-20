package com.leoncam.sortrforflickr.dagger.components;

import com.leoncam.sortrforflickr.FlickrApp;
import com.leoncam.sortrforflickr.dagger.modules.AppModule;
import com.leoncam.sortrforflickr.dagger.modules.MainFeedModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {AppModule.class}
)
public interface AppComponent {
    void inject(FlickrApp flickrApp);

    MainFeedComponent plus(MainFeedModule mainFeedModule);
}
