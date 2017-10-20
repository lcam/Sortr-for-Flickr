package com.leoncam.sortrforflickr;

import com.leoncam.sortrforflickr.model.FlickrImages;
import com.leoncam.sortrforflickr.presenter.GridPresenter;
import com.leoncam.sortrforflickr.services.FlickrServices;
import com.leoncam.sortrforflickr.view.MainFeedView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Unit testing for GridPresenter.
 */
public class GridPresenterUnitTest {

    private static FlickrImages flickrImages = new FlickrImages();

    private GridPresenter mGridPresenter;

    @Mock
    private MainFeedView mainFeedView;

    @Mock
    private FlickrServices flickrServices;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mGridPresenter = new GridPresenter(mainFeedView, flickrServices);
    }

    @Test
    public void loadQuestionsFromNetworkAndLoadIntoView() {
        // Loading of data is requested
        mGridPresenter.loadData("");

        // Verify network service makes network call
        verify(flickrServices).loadData("");

        // Attempt to pass the data back to the view
        mGridPresenter.updateView(flickrImages);

        // Verify view attempts to update
        verify(mainFeedView).updateList(flickrImages);
    }

    @Test
    public void attemptLoadQuestionsAndFailToLoad() {
        // Loading of data is requested
        mGridPresenter.loadData("");

        // Verify network service makes network call
        verify(flickrServices).loadData("");

        // Fails to retrieve data and call presenter to display error in UI
        mGridPresenter.updateViewFailed();

        // Verify view shows error message
        verify(mainFeedView).loadFailed();
    }
}