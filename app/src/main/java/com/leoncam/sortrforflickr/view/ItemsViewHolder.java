package com.leoncam.sortrforflickr.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.leoncam.sortrforflickr.R;

// Provide a direct reference to each of the views within a data item
// Used to cache the views within the item layout for fast access
public class ItemsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    // Your holder should contain a member variable
    // for any view that will be set as you render a row
    public ImageView imageThumbnail;
    public IMyViewHolderClicks mListener;

    // We also create a constructor that accepts the entire item row
    // and does the view lookups to find each subview
    public ItemsViewHolder(View itemView) { //NOTICE: NO LONGER PASSING IMyViewHolderClicks INTERFACE AS A PARAMETER
        // Stores the itemView in a public final member variable that can be used
        // to access the context from any ViewHolder instance.
        super(itemView);

        //mListener = listener; //NOTICE: ASSIGN mListener in onCreateViewHolder, NOT HERE
        imageThumbnail = (ImageView) itemView.findViewById(R.id.image_thumbnail);

        imageThumbnail.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mListener.onImageThumbnail((ImageView)view);
    }

    public static interface IMyViewHolderClicks {
        public void onImageThumbnail(ImageView callerImage);
    }
}
