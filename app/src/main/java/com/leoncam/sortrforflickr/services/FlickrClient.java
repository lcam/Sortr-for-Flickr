package com.leoncam.sortrforflickr.services;

import com.leoncam.sortrforflickr.model.FlickrImages;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrClient {
    // https://api.flickr.com/services
    // /feeds/photos_public.gne?tags=anime&format=json&nojsoncallback=1
    @GET("feeds/photos_public.gne?format=json&nojsoncallback=1")
    Call<FlickrImages> loadImages(
            @Query("tags") String tag
    );
}
