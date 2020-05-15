package com.example.nikolay_plyushchay_shop.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.nikolay_plyushchay_shop.R

fun drawImageFromUrl(imageView: ImageView, imageUrl: String?) {
    Glide
        .with(imageView.context)
        .load(imageUrl)
        .error(R.drawable.ic_photo_24dp)
        .into(imageView)
}