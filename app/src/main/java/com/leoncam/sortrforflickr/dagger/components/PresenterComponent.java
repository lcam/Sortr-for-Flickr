package com.leoncam.sortrforflickr.dagger.components;

import com.leoncam.sortrforflickr.dagger.modules.AppModule;
import com.leoncam.sortrforflickr.dagger.modules.PresenterModule;
import com.leoncam.sortrforflickr.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {AppModule.class, PresenterModule.class }
)
public interface PresenterComponent {
    void inject(MainActivity activity);
}
