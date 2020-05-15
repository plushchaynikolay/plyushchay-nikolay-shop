package com.example.nikolay_plyushchay_shop.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.nikolay_plyushchay_shop.R
import kotlin.math.round

fun drawImageFromUrl(imageView: ImageView, imageUrl: String?) {
    Glide
        .with(imageView.context)
        .load(imageUrl)
        .error(R.drawable.ic_photo_24dp)
        .into(imageView)
}

fun format(price: Double): String {
    val roundedPrice = round(100.0 * price) / 100.0
    val digits: Int = if (roundedPrice % 1 > 0) 2 else 0
    return "%.${digits}f".format(roundedPrice)
}