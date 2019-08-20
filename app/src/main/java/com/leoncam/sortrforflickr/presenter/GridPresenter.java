package com.leoncam.sortrforflickr.presenter;

import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import com.leoncam.sortrforflickr.R;
import com.leoncam.sortrforflickr.model.FlickrImages;
import com.leoncam.sortrforflickr.services.FlickrServices;
import com.leoncam.sortrforflickr.view.MainFeedView;

public class GridPresenter implements ServiceCallback{

    private MainFeedView view;
    private FlickrServices service;

    public GridPresenter(MainFeedView view, FlickrServices service) {
        this.view = view;
        this.service = service;
        service.setCallback(this);
    }

    public void loadData(String tag) {
        service.loadData(tag);
    }

    @Override
    public void updateView(FlickrImages flickrImages) {
        view.updateList(flickrImages);
    }

    @Override
    public void updateViewFailed() {
        view.loadFailed();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.miSearch:
                view.submit();
                return true;
            default:
                return false;
                //return super.onOptionsItemSelected(item);
        }
    }

    public boolean onEditorAction(int actionId){
        if (EditorInfo.IME_ACTION_DONE == actionId) {
            view.submit();
            return true;
        }
        return false;
    }
}
