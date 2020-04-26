package com.example.nikolay_plyushchay_shop.presenter

import com.example.nikolay_plyushchay_shop.domain.ViewedProductDao
import com.example.nikolay_plyushchay_shop.domain.model.Basket
import com.example.nikolay_plyushchay_shop.domain.model.Product
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class BasketPresenter(
    private val viewedProductDao: ViewedProductDao
) : MvpPresenter<BasketView>() {
    private val basket = Basket(
        mutableListOf(
            Product("Rainbow Dash", 100.0),
            Product("Twilight Sparkle", 120.0, 15)
        )
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        setItems()
    }

    override fun attachView(view: BasketView?) {
        super.attachView(view)
        val productIds = viewedProductDao.getAllProducts()
        viewState.showProductIds(productIds)
    }

    fun setItems() = viewState.setItems(basket.products)

    fun removeItem(name: String) {
        val product = basket.products.find { p -> p.name == name }
        val position = basket.products.indexOf(product)
        basket.products.removeAt(position)
        viewState.removeItem(position)
    }
}