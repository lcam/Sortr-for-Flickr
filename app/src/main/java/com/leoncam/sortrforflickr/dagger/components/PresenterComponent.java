package com.leoncam.sortrforflickr.dagger.components;

import com.leoncam.sortrforflickr.dagger.modules.ServiceModule;
import com.leoncam.sortrforflickr.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = { ServiceModule.class }
)
public interface PresenterComponent {
    void inject(MainActivity activity);
}
