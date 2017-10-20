package com.leoncam.sortrforflickr.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.leoncam.sortrforflickr.R;
import com.leoncam.sortrforflickr.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsViewHolder>{

    private List<Item> mItems;
    private final Context mContext;

    public ItemsAdapter(Context context, List<Item> items) {
        mItems = items;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View itemView = inflater.inflate(R.layout.item_image, parent, false);

        // Return a new holder instance
        final ItemsViewHolder viewHolder = new ItemsViewHolder(itemView);
        viewHolder.mListener = new ItemsViewHolder.IMyViewHolderClicks() {
            @Override
            public void onImageThumbnail(ImageView callerImage) {
                final int position = viewHolder.getAdapterPosition();

                Intent intent = new Intent(callerImage.getContext(), FullSizeImageView.class);
                intent.putExtra("image_link", mItems.get(position).getMedia().getM());
                intent.putExtra("title", mItems.get(position).getTitle());
                intent.putExtra("author", mItems.get(position).getAuthor());
                callerImage.getContext().startActivity(intent);
            }
        };
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemsViewHolder viewHolder, int position) {
        // Use Picasso to load images from network call
        String imageUrl = mItems.get(position).getMedia().getM();

        // Manipulate image url for larger thumbnail - based on Flickr API
        imageUrl = imageUrl.replace("_m.jpg", "_c.jpg");
        Picasso.with(viewHolder.imageThumbnail.getContext())
                .load(imageUrl)
                .resize(700, 700)
                .centerCrop()
                .into(viewHolder.imageThumbnail);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
