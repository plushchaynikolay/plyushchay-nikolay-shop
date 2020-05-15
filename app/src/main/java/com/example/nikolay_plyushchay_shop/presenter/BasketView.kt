package com.example.nikolay_plyushchay_shop.presenter

import com.example.nikolay_plyushchay_shop.domain.model.Basket
import com.example.nikolay_plyushchay_shop.domain.model.Product
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface BasketView : MvpView {
    fun setItems(products: List<Product>)
    fun removeItem(position: Int)
    fun openBasketOrder(basket: Basket)
    fun setOrderBtnEnabledStatus(status: Boolean)
}