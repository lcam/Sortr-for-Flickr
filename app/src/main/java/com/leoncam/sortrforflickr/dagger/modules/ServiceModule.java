package com.leoncam.sortrforflickr.dagger.modules;

import com.leoncam.sortrforflickr.services.FlickrAPI;
import com.leoncam.sortrforflickr.services.ServiceGenerator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ServiceModule {

    private String BASE_URL = "https://api.flickr.com/services/";

    @Provides
    ServiceGenerator provideServiceGenerator(FlickrAPI flickrAPI) {
        return new ServiceGenerator(flickrAPI);
    }

    @Provides
    FlickrAPI provideFlickrAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(FlickrAPI.class);
    }
}
