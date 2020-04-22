package com.example.nikolay_plyushchay_shop.ui

import com.example.nikolay_plyushchay_shop.model.Product
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface BasketView : MvpView {
    fun setItems(products: List<Product>)
    fun removeItem(position: Int)
}