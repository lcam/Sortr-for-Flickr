package com.leoncam.sortrforflickr.services;

import android.util.Log;

import com.leoncam.sortrforflickr.model.FlickrImages;
import com.leoncam.sortrforflickr.presenter.GridPresenter;
import com.leoncam.sortrforflickr.view.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    public static final String API_BASE_URL = "https://api.flickr.com/services/";
    private FlickrClient flickrClient;
    private GridPresenter presenter;

    public ServiceGenerator(MainActivity mainActivity) {
        presenter = new GridPresenter(mainActivity, this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        flickrClient = retrofit.create(FlickrClient.class);
    }

    public void loadData(String tag) {
        Call<FlickrImages> call = flickrClient.loadImages(tag);
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

//    public void loadTags() {
//        Call<FlickrHotTags> call = flickrClient.loadTags();
//        // asynchronous call to API
//        call.enqueue(new Callback<FlickrHotTags>() {
//            @Override
//            public void onResponse(Call<FlickrHotTags> call, Response<FlickrHotTags> response) {
//                FlickrHotTags flickrHotTags = response.body();
//                presenter.updateTags(flickrHotTags);
//            }
//
//            @Override
//            public void onFailure(Call<FlickrHotTags> call, Throwable t) {
//                Log.d("Error", t.getMessage());
//                presenter.updateViewFailed();
//            }
//        });
//    }

}
