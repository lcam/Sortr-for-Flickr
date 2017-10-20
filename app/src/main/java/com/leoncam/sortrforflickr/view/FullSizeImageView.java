package com.leoncam.sortrforflickr.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.leoncam.sortrforflickr.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FullSizeImageView extends AppCompatActivity {

    @BindView(R.id.image_title)
            TextView imageTitle;
    @BindView(R.id.image_full)
            ImageView imageView;
    String imageLink;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        ButterKnife.bind(this);

        title = getIntent().getStringExtra("title");
        imageTitle.setText("Title: " + title);

        imageLink = getIntent().getStringExtra("image_link");

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
