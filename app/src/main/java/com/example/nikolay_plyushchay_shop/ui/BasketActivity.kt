package com.example.nikolay_plyushchay_shop.ui

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nikolay_plyushchay_shop.R
import com.example.nikolay_plyushchay_shop.presenter.BasketPresenter
import kotlinx.android.synthetic.main.activity_basket.*

class BasketActivity : BaseActivity(), BasketView {
    private val presenter = BasketPresenter()
    private val adapter = BasketAdapter { p -> presenter.removeItem(p) }

    override fun removeItem(position: Int) = adapter.notifyItemRemoved(position)
    override fun setItems(list: List<String>) = adapter.setItems(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket)
        basketRv.layoutManager = LinearLayoutManager(this)
        basketRv.adapter = adapter
        presenter.attachView(this)
        presenter.setItems()
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
