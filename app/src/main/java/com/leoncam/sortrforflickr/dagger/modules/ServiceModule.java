package com.leoncam.sortrforflickr.dagger.modules;

import com.leoncam.sortrforflickr.services.ServiceGenerator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {

    @Provides
    @Singleton
    public ServiceGenerator provideServiceGenerator(){
        return new ServiceGenerator();
    }
}
