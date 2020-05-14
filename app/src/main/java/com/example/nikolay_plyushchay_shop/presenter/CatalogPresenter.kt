package com.example.nikolay_plyushchay_shop.presenter

import com.example.nikolay_plyushchay_shop.domain.BasketProductDao
import com.example.nikolay_plyushchay_shop.domain.MainApi
import com.example.nikolay_plyushchay_shop.domain.model.Product
import kotlinx.coroutines.launch
import moxy.InjectViewState
import java.net.ConnectException
import java.net.UnknownHostException
import javax.inject.Inject

@InjectViewState
class CatalogPresenter @Inject constructor(
    private val api: MainApi,
    private val basketProductDao: BasketProductDao
) : CoroutinePresenter<CatalogView>() {
    lateinit var products: List<Product>

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        launch { loadProducts() }
    }

    override fun attachView(view: CatalogView?) {
        super.attachView(view)
        if (!this::products.isInitialized)
            launch { loadProducts() }
    }

    private suspend fun loadProducts() {
        try {
            val remoteProducts = api.allProducts()
            products = remoteProducts.mapNotNull { r ->
                try {
                    Product(r.name, r.price, r.discount, r.description, r.imageUrl, r.id)
                } catch (e: VerifyError) {
                    null
                }
            }
            viewState.setItems(products)
        } catch (e: UnknownHostException) {
            viewState.showServerError()
        } catch (e: ConnectException) {
            viewState.showInternetError()
        }
    }
}