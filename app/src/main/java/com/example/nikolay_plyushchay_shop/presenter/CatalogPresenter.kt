package com.example.nikolay_plyushchay_shop.presenter

import com.example.nikolay_plyushchay_shop.domain.model.Product
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class CatalogPresenter : MvpPresenter<CatalogView>() {
    val products = listOf(
        Product("Applejack", 130.0),
        Product("Pinkie Pie", 150.0, 20),
        Product("Rarity", 115.0)
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setItems(products)
    }
}