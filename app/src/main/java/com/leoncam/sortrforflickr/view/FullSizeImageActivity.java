package com.leoncam.sortrforflickr.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.leoncam.sortrforflickr.R;
import com.squareup.picasso.Picasso;

public class FullSizeImageActivity extends AppCompatActivity {

    String imageLink;
    String title;
    String author;
    ImageView imageView;
    TextView imageAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        // Find the toolbar view inside the activity layout
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //title = getIntent().getStringExtra("title");
        //toolbar.setTitle(title);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        //setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        author = getIntent().getStringExtra("author");
        imageAuthor = (TextView) findViewById(R.id.image_author);
        imageAuthor.setText("Author: " + author);

        imageLink = getIntent().getStringExtra("image_link");
        imageView = (ImageView) findViewById(R.id.image_full);

        // Manipulate the url suffix to display full image - based on Flickr API
        imageLink = imageLink.replace("_m.jpg", "_h.jpg");

        // Load image from url using Picasso
        Picasso.with(this)
                .load(imageLink)
                .fit()
                .centerInside()
                .into(imageView);
    }
}
