package com.example.nikolay_plyushchay_shop.ui

import android.os.Bundle
import com.example.nikolay_plyushchay_shop.R
import kotlinx.android.synthetic.main.activity_product_info.*

class ProductInfoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_info)
        setListeners()
    }

    private fun setListeners() {
        buttonProductGoBack.setOnClickListener { finish() }
    }

    companion object {
        val PRODUCT_TAG = "PRODUCT_TAG"
    }
}
