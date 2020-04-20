package com.example.nikolay_plyushchay_shop.ui

import android.content.Intent
import android.os.Bundle
import com.example.nikolay_plyushchay_shop.R
import kotlinx.android.synthetic.main.activity_catalog.*

class CatalogActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)
        setListeners()
    }

    private fun setListeners() {
        buttonToBasket.setOnClickListener {
            val intent = Intent(this, BasketActivity::class.java)
            startActivity(intent)
        }
    }
}
