package com.leoncam.sortrforflickr.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.leoncam.sortrforflickr.R;
import com.squareup.picasso.Picasso;

import static android.R.attr.author;

public class FullSizeImageActivity extends AppCompatActivity {

    String imageLink;
    String title;
    ImageView imageView;
    TextView imageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        title = getIntent().getStringExtra("title");
        imageTitle = (TextView) findViewById(R.id.image_title);
        imageTitle.setText("Title: " + title);

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
