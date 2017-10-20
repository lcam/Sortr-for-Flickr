package com.leoncam.sortrforflickr.dagger.modules;

import com.leoncam.sortrforflickr.presenter.GridPresenter;
import com.leoncam.sortrforflickr.services.FlickrAPI;
import com.leoncam.sortrforflickr.services.FlickrServices;
import com.leoncam.sortrforflickr.view.MainFeedView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MainFeedModule {
    MainFeedView activity;
    private String BASE_URL = "https://api.flickr.com/services/";

    public MainFeedModule(MainFeedView activity){
        this.activity = activity;
    }

    @Provides
    GridPresenter provideGridPresenter(FlickrServices service){
        return new GridPresenter(activity, service);
    }

    @Provides
    FlickrServices provideServiceGenerator(FlickrAPI flickrAPI) {
        return new FlickrServices(flickrAPI);
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
