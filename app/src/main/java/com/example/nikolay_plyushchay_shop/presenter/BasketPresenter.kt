package com.example.nikolay_plyushchay_shop.presenter

import com.example.nikolay_plyushchay_shop.domain.BasketProductDao
import com.example.nikolay_plyushchay_shop.domain.model.Basket
import com.example.nikolay_plyushchay_shop.domain.model.Product
import moxy.InjectViewState

@InjectViewState
class BasketPresenter(
    private val basketProductDao: BasketProductDao
) : BasePresenter<BasketView>() {
    private val basket = Basket(
        mutableListOf(
            Product("Rainbow Dash", 100.0, id = "0"),
            Product("Twilight Sparkle", 120.0, 15, id = "1")
        )
    )

    fun setItems() = viewState.setItems(basket.products)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        setItems()
    }

    fun removeItem(id: String) {
        val product = basket.products.find { p -> p.id == id }
        val position = basket.products.indexOf(product)
        basket.products.removeAt(position)
        viewState.removeItem(position)
    }
}