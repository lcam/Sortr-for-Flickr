package com.leoncam.sortrforflickr.dagger.components;


import com.leoncam.sortrforflickr.dagger.modules.MainFeedModule;
import com.leoncam.sortrforflickr.view.MainFeedView;

import dagger.Subcomponent;

@Subcomponent(
        modules = {MainFeedModule.class}
)
public interface MainFeedComponent {
    void inject(MainFeedView mainFeedView);
}
