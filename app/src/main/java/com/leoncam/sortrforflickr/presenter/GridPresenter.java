package com.leoncam.sortrforflickr.presenter;

import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import com.leoncam.sortrforflickr.R;
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
        view.updateList(flickrImages);
    }

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
