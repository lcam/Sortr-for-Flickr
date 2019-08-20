package com.leoncam.sortrforflickr.presenter;

import com.leoncam.sortrforflickr.model.FlickrImages;

import java.util.List;

public interface ServiceCallback {
    void updateView(FlickrImages flickrImages);
    void updateViewFailed();
}
