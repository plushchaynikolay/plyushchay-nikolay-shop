package com.example.nikolay_plyushchay_shop.ui

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface BasketView : MvpView {
    fun setItems(list: List<String>)
    fun removeItem(position: Int)
}