package com.example.nikolay_plyushchay_shop.presenter

import com.example.nikolay_plyushchay_shop.domain.MainApi
import com.example.nikolay_plyushchay_shop.domain.model.Product
import kotlinx.coroutines.launch
import moxy.InjectViewState

@InjectViewState
class CatalogPresenter(
    private val api: MainApi
) : CoroutinePresenter<CatalogView>() {
    var products = listOf(
        Product("Applejack", 130.0),
        Product("Pinkie Pie", 150.0, 20),
        Product("Rarity", 115.0)
    )


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        launch {
            val remoteProducts = api.allProducts()
            products = remoteProducts.mapNotNull { r ->
                try {
                    Product(r.name, r.price, r.discount, r.description, r.id)
                } catch (e: VerifyError) {
                    null
                }
            }
            viewState.setItems(products)
        }
    }
}