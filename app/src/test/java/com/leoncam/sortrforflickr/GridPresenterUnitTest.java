package com.leoncam.sortrforflickr;

import com.leoncam.sortrforflickr.model.FlickrImages;
import com.leoncam.sortrforflickr.presenter.GridPresenter;
import com.leoncam.sortrforflickr.services.ServiceGenerator;
import com.leoncam.sortrforflickr.view.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Unit testing for GridPresenter.
 */
public class GridPresenterUnitTest {

    private static FlickrImages flickrImages = new FlickrImages();

    private GridPresenter mGridPresenter;

    @Mock
    private MainActivity mainActivity;

    @Mock
    private ServiceGenerator serviceGenerator;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mGridPresenter = new GridPresenter(mainActivity, serviceGenerator);
    }

    @Test
    public void loadQuestionsFromNetworkAndLoadIntoView() {
        // Loading of data is requested
        mGridPresenter.loadData("");

        // Verify network service makes network call
        verify(serviceGenerator).loadData("");

        // Attempt to pass the data back to the view
        mGridPresenter.updateView(flickrImages);

        // Verify view attempts to update
        verify(mainActivity).updateList(flickrImages);
    }

    @Test
    public void attemptLoadQuestionsAndFailToLoad() {
        // Loading of data is requested
        mGridPresenter.loadData("");

        // Verify network service makes network call
        verify(serviceGenerator).loadData("");

        // Fails to retrieve data and call presenter to display error in UI
        mGridPresenter.updateViewFailed();

        // Verify view shows error message
        verify(mainActivity).loadFailed();
    }
}