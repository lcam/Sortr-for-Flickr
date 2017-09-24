package com.leoncam.sortrforflickr.view;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.leoncam.sortrforflickr.R;
import com.leoncam.sortrforflickr.model.FlickrImages;
import com.leoncam.sortrforflickr.presenter.GridPresenter;
import com.leoncam.sortrforflickr.services.ServiceGenerator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

    @BindView(R.id.toolbar)
        Toolbar toolbar;
    @BindView(R.id.rvImages)
        RecyclerView rvItems;
    @BindView(R.id.etTag)
        EditText mEditText;
    @BindView(R.id.refresh_layout)
        SwipeRefreshLayout swipeRefreshLayout;

    private GridLayoutManager layoutManager;
    private ItemsAdapter adapter;
    int numColumn = 2;

    private String tagInput = "";
    private GridPresenter mGridPresenter;
    private ServiceGenerator mNetworkService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Sets the Toolbar to act as the ActionBar for this Activity window.
        setSupportActionBar(toolbar);

        // Setup a callback when the "Done" button is pressed on keyboard
        mEditText.setOnEditorActionListener(this);

        //suppress the soft-keyboard until the user actually touches the editText View
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

        mNetworkService = new ServiceGenerator();
        mGridPresenter = new GridPresenter(this, mNetworkService);

        getData("");

        layoutManager = new GridLayoutManager(this, numColumn);
        rvItems.setLayoutManager(layoutManager);

        // Swipe down to refresh
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData(tagInput);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.miSearch:
                tagInput = mEditText.getText().toString();
                getData(tagInput);

                //hide keyboard
                View view = this.getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void getData(String tag) {
        mGridPresenter.loadData(tag);
    }

    public void updateList(FlickrImages images) {
        adapter = new ItemsAdapter(getApplicationContext(), images.getItems());
        rvItems.setAdapter(adapter);
        swipeRefreshLayout.setRefreshing(false); //suppress loading spinner after refresh
    }

    public void loadFailed() {
        Snackbar.make(rvItems, "Images could not be loaded", Snackbar.LENGTH_LONG).show();
        swipeRefreshLayout.setRefreshing(false); //suppress loading spinner after refresh
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if (EditorInfo.IME_ACTION_DONE == actionId) {
            tagInput = mEditText.getText().toString();
            getData(tagInput);

            //hide keyboard
            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

            return true;
        }
        return false;
    }
}