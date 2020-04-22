package com.example.nikolay_plyushchay_shop.presenter

import com.example.nikolay_plyushchay_shop.model.Product
import com.example.nikolay_plyushchay_shop.ui.ProductView
import moxy.MvpPresenter
import kotlin.math.round

class ProductPresenter(
    var product: Product
) : MvpPresenter<ProductView>() {
    fun print() = viewState.print(format(product.discountPrice))
}

fun format(price: Double): String {
    val roundedPrice = round(100.0 * price) / 100.0
    val digits: Int = if (roundedPrice % 1 > 0) 2 else 0
    return "%.${digits}f".format(roundedPrice)
}
