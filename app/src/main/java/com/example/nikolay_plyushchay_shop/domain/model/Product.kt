package com.example.nikolay_plyushchay_shop.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize


@Parcelize
class Product(
    val name: String,
    val price: Double,
    val discount: Int = 0,
    val description: String = "",
    val imageUrl: String? = null,
    val id: String
) : Parcelable {
    init {
        if (price < 0.0) throw VerifyError("Price must be positive")
        if (discount > 100) throw VerifyError("Sale percent can't be more than 100")
    }

    @IgnoredOnParcel
    val discountPrice: Double = price * (1 - discount / 100.0)
}
