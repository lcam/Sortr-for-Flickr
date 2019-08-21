package com.leoncam.sortrforflickr.services;

import android.util.Log;

import com.leoncam.sortrforflickr.model.FlickrImages;
import com.leoncam.sortrforflickr.presenter.GridPresenter;
import com.leoncam.sortrforflickr.presenter.ServiceCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlickrServices {

    //private static final String API_BASE_URL = "https://api.flickr.com/services/";
    private FlickrAPI flickrAPI;
    //private GridPresenter presenter;
    private ServiceCallback serviceCallback;

    public FlickrServices(FlickrAPI flickrAPI) {
        this.flickrAPI = flickrAPI;
    }

    public void setCallback(ServiceCallback serviceCallback){
        //this.presenter = presenter;
        this.serviceCallback = serviceCallback;
    }

    public void loadData(String tag) {
        Call<FlickrImages> call = flickrAPI.loadImages(tag);
        // asynchronous call to API
        call.enqueue(new Callback<FlickrImages>() {
            @Override
            public void onResponse(Call<FlickrImages> call, Response<FlickrImages> response) {
                FlickrImages flickrImages = response.body();
                serviceCallback.onFlickrImagesLoaded(flickrImages);
            }

            @Override
            public void onFailure(Call<FlickrImages> call, Throwable t) {
                Log.d("Error", t.getMessage());
                serviceCallback.onFlickrImagesError();
            }
        });
    }
}
