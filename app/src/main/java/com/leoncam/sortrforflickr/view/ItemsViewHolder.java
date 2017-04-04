package com.leoncam.sortrforflickr.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.leoncam.sortrforflickr.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ItemsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    @BindView(R.id.image_thumbnail)
        ImageView imageThumbnail;

    public IMyViewHolderClicks mListener;

    public ItemsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @OnClick({
            R.id.image_thumbnail
    })
    public void onClick(View view) {
        mListener.onImageThumbnail((ImageView)view);
    }

    public interface IMyViewHolderClicks {
        void onImageThumbnail(ImageView callerImage);
    }
}
