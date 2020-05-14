package com.example.nikolay_plyushchay_shop.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nikolay_plyushchay_shop.App
import com.example.nikolay_plyushchay_shop.R
import com.example.nikolay_plyushchay_shop.domain.model.Product
import com.example.nikolay_plyushchay_shop.presenter.CatalogPresenter
import com.example.nikolay_plyushchay_shop.presenter.CatalogView
import com.example.nikolay_plyushchay_shop.ui.ProductInfoActivity.Companion.PRODUCT_TAG
import kotlinx.android.synthetic.main.activity_catalog.*
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class CatalogActivity : BaseActivity(), CatalogView {

    @Inject
    lateinit var catalogPresenter: CatalogPresenter

    private val presenter by moxyPresenter { catalogPresenter }
    private val adapter = CatalogAdapter(
        { openProductInfo(it) },
        { presenter.addProductToBasket(it) }
    )

    override fun setItems(products: List<Product>) = adapter.setItems(products)

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)
        setListeners()
        catalogRv.layoutManager = LinearLayoutManager(this)
        catalogRv.adapter = adapter
    }

    private fun setListeners() = buttonToBasket.setOnClickListener {
        startActivity(Intent(this, BasketActivity::class.java))
    }

    private fun openProductInfo(product: Product) = startActivity(
        Intent(this, ProductInfoActivity::class.java)
            .apply { putExtra(PRODUCT_TAG, product) })

    override fun showInternetError() =
        Toast.makeText(this, "Проверьте подключение к интернету", Toast.LENGTH_LONG)
            .show()

    override fun showServerError() =
        Toast.makeText(this, "Сервер товаров временно недоступен", Toast.LENGTH_LONG)
            .show()

    override fun showProductAdded() =
        Toast.makeText(this, "Добавлено", Toast.LENGTH_LONG)
            .show()
}
