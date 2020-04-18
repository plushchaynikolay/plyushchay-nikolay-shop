package com.example.nikolay_plyushchay_shop.presenter

import com.example.nikolay_plyushchay_shop.model.Product

class ProductPresenter(
    private val product: Product
) : Presenter() {
    override fun print() = viewState.print(
        format(
            product.discountPrice
        )
    )
}
