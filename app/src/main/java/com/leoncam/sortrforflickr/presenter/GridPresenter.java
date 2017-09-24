package com.leoncam.sortrforflickr.presenter;

import com.leoncam.sortrforflickr.model.FlickrImages;
import com.leoncam.sortrforflickr.services.ServiceGenerator;
import com.leoncam.sortrforflickr.view.MainActivity;


public class GridPresenter {

    private MainActivity view;
    private ServiceGenerator service;

    public GridPresenter(MainActivity view, ServiceGenerator service) {
        this.view = view;
        this.service = service;
        service.setCallback(this);
    }

    public void loadData(String tag) {
        service.loadData(tag);
    }

    public void updateView(FlickrImages flickrImages) {
        ////
        view.updateList(flickrImages);
    }

    public void updateViewFailed() {
        /////
        view.loadFailed();
    }
}
