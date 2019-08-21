package com.leoncam.sortrforflickr.presenter;

import com.leoncam.sortrforflickr.model.FlickrImages;

import java.util.List;

public interface ServiceCallback {
    void onFlickrImagesLoaded(FlickrImages flickrImages);
    void onFlickrImagesError();
}
