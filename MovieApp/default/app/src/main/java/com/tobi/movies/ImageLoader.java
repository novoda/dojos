package com.tobi.movies;

import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageLoader {

    public void loadWebImageInto(Uri imageUrl, ImageView imageView) {
        Glide
                .with(imageView.getContext())
                .load(imageUrl)
                .crossFade()
                .into(imageView);
    }
}
