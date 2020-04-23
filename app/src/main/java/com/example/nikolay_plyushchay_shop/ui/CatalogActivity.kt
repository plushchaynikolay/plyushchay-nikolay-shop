package com.example.nikolay_plyushchay_shop.ui

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nikolay_plyushchay_shop.R
import com.example.nikolay_plyushchay_shop.model.Product
import kotlinx.android.synthetic.main.activity_catalog.*

class CatalogActivity : BaseActivity() {
    private val list = listOf(
        Product("Applejack", 130.0),
        Product("Pinkie Pie", 150.0, 20),
        Product("Rarity", 115.0)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)
        setListeners()

        catalogRv.layoutManager = LinearLayoutManager(this)
        catalogRv.adapter = CatalogAdapter(list)
    }

    private fun setListeners() {
        buttonToBasket.setOnClickListener {
            val intent = Intent(this, BasketActivity::class.java)
            startActivity(intent)
        }
    }
}
