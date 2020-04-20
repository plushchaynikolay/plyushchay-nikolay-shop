package com.example.nikolay_plyushchay_shop.ui

import android.content.Intent
import android.os.Bundle
import com.example.nikolay_plyushchay_shop.R
import kotlinx.android.synthetic.main.activity_basket.*

class BasketActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket)
        setListeners()
    }

    private fun setListeners() {
        buttonBasketGoBack.setOnClickListener { finish() }
        buttonMakeOrder.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }
    }
}
