package com.example.nikolay_plyushchay_shop.ui

import android.os.Bundle
import com.example.nikolay_plyushchay_shop.R
import com.example.nikolay_plyushchay_shop.domain.model.Product
import com.example.nikolay_plyushchay_shop.presenter.ProductView
import com.example.nikolay_plyushchay_shop.utils.drawImageFromUrl
import kotlinx.android.synthetic.main.activity_product_info.*

class ProductInfoActivity : BaseActivity(), ProductView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_info)
        val product = intent?.getParcelableExtra<Product>(PRODUCT_TAG) ?: return
        setProductInfoLayout(product)
        setListeners()
    }

    override fun setProductInfoLayout(product: Product) {
        drawImageFromUrl(ivImage, product.imageUrl)
        productHeader.text = product.name
        tvDescription.text = product.description
    }

    private fun setListeners() {
        buttonProductGoBack.setOnClickListener { finish() }
    }

    companion object {
        const val PRODUCT_TAG = "PRODUCT_TAG"
    }
}
