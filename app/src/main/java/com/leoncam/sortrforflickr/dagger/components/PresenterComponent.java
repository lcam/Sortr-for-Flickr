package com.leoncam.sortrforflickr.dagger.components;


import com.leoncam.sortrforflickr.dagger.modules.PresenterModule;
import com.leoncam.sortrforflickr.view.MainActivity;

import dagger.Subcomponent;

@Subcomponent(
        modules = {PresenterModule.class}
)
public interface PresenterComponent {
    void inject(MainActivity mainActivity);
}
