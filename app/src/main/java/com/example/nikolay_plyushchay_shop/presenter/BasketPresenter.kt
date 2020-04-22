package com.example.nikolay_plyushchay_shop.presenter

import com.example.nikolay_plyushchay_shop.model.Basket
import com.example.nikolay_plyushchay_shop.model.Product
import com.example.nikolay_plyushchay_shop.ui.BasketView
import moxy.MvpPresenter

class BasketPresenter : MvpPresenter<BasketView>() {
    private val basket = Basket(
        mutableListOf(
            Product("Rainbow Dash", 100.0),
            Product("Twilight Sparkle", 120.0, 15)
        )
    )

    fun setItems() = viewState.setItems(basket.products)

    fun removeItem(name: String) {
        val product = basket.products.find { p -> p.name == name }
        val position = basket.products.indexOf(product)
        basket.products.removeAt(position)
        viewState.removeItem(position)
    }
}