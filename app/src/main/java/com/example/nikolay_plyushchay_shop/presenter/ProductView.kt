package com.example.nikolay_plyushchay_shop.presenter

import com.example.nikolay_plyushchay_shop.domain.model.Product
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProductView : MvpView {
    fun setProductInfoLayout(product: Product)
}