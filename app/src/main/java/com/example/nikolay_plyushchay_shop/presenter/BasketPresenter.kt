package com.example.nikolay_plyushchay_shop.presenter

import com.example.nikolay_plyushchay_shop.domain.BasketProductDao
import com.example.nikolay_plyushchay_shop.domain.model.Basket
import com.example.nikolay_plyushchay_shop.domain.model.Product
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class BasketPresenter @Inject constructor(
    private val basketProductDao: BasketProductDao
) : BasePresenter<BasketView>() {
    private val basket = Basket(basketProductDao.getAllProducts().toMutableList())

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        setItems()
    }

    fun setItems() = viewState.setItems(basket.products)

    fun passBasketToOrder() = viewState.openBasketOrder(basket)

    fun removeItem(product: Product) {
        basketProductDao.removeProduct(product)
        val position = basket.products.indexOf(product)
        basket.products.removeAt(position)
        viewState.removeItem(position)
    }
}