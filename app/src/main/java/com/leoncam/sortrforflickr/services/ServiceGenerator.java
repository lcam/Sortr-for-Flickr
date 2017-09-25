package com.leoncam.sortrforflickr.services;

import android.util.Log;

import com.leoncam.sortrforflickr.model.FlickrImages;
import com.leoncam.sortrforflickr.presenter.GridPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static final String API_BASE_URL = "https://api.flickr.com/services/";
    private FlickrAPI flickrAPI;
    private GridPresenter presenter;

    public ServiceGenerator() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        flickrAPI = retrofit.create(FlickrAPI.class);
    }

    public void setCallback(GridPresenter presenter){
        this.presenter = presenter;
    }

    public void loadData(String tag) {
        Call<FlickrImages> call = flickrAPI.loadImages(tag);
        // asynchronous call to API
        call.enqueue(new Callback<FlickrImages>() {
            @Override
            public void onResponse(Call<FlickrImages> call, Response<FlickrImages> response) {
                FlickrImages flickrImages = response.body();
                presenter.updateView(flickrImages);
            }

            @Override
            public void onFailure(Call<FlickrImages> call, Throwable t) {
                Log.d("Error", t.getMessage());
                presenter.updateViewFailed();
            }
        });
    }
}
