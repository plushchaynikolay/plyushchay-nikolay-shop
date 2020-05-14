package com.example.nikolay_plyushchay_shop.ui

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nikolay_plyushchay_shop.R
import com.example.nikolay_plyushchay_shop.data.SharedPreferencesBasketDao
import com.example.nikolay_plyushchay_shop.domain.model.Product
import com.example.nikolay_plyushchay_shop.presenter.BasketPresenter
import com.example.nikolay_plyushchay_shop.presenter.BasketView
import kotlinx.android.synthetic.main.activity_basket.*
import moxy.ktx.moxyPresenter

class BasketActivity : BaseActivity(), BasketView {
    private val presenter by moxyPresenter {
        BasketPresenter(
            SharedPreferencesBasketDao(sharedPreferences)
        )
    }
    private val adapter = BasketAdapter(
        { p -> presenter.removeItem(p) },
        { p -> openProductInfo(p) }
    )

    override fun removeItem(position: Int) = adapter.notifyItemRemoved(position)
    override fun setItems(products: List<Product>) = adapter.setItems(products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket)
        basketRv.layoutManager = LinearLayoutManager(this)
        basketRv.adapter = adapter
        setListeners()
    }

    private fun setListeners() {
        buttonBasketGoBack.setOnClickListener { finish() }
        buttonMakeOrder.setOnClickListener {
            startActivity(Intent(this, OrderActivity::class.java))
        }
    }

    private fun openProductInfo(product: Product) {
        startActivity(Intent(this, ProductInfoActivity::class.java)
            .apply { putExtra(ProductInfoActivity.PRODUCT_TAG, product) })
    }
}
