package com.leoncam.sortrforflickr.dagger.components;

import com.leoncam.sortrforflickr.dagger.modules.AppModule;
import com.leoncam.sortrforflickr.dagger.modules.NetModule;
import com.leoncam.sortrforflickr.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = { AppModule.class, NetModule.class }
)
public interface NetComponent {
    void inject(MainActivity activity);
}
