package com.example.nikolay_plyushchay_shop.ui

import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.nikolay_plyushchay_shop.R
import com.example.nikolay_plyushchay_shop.domain.model.Basket
import com.example.nikolay_plyushchay_shop.presenter.OrderPresenter
import com.example.nikolay_plyushchay_shop.presenter.OrderView
import com.example.nikolay_plyushchay_shop.utils.AfterTextChangedWatcher
import kotlinx.android.synthetic.main.activity_order.*
import moxy.ktx.moxyPresenter

class OrderActivity : BaseActivity(), OrderView {
    private val presenter by moxyPresenter { OrderPresenter() }

    override fun printTotal(price: String, count: String, discount: String?) {
        textTotalPriceValue.text = price
        textTotalCountValue.text = count
        if (discount != null) {
            textTotalDiscount.visibility = View.VISIBLE
            textTotalDiscountValue.visibility = View.VISIBLE
            textTotalDiscountValue.text = discount
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val basket = intent?.getParcelableExtra(BASKET_TAG) ?: Basket(mutableListOf())
        presenter.setBasket(basket)
        setListeners()
    }

    override fun showErrorFirstName(visible: Boolean) = nameFirstField.showError(visible)
    override fun showErrorLastName(visible: Boolean) = nameLastField.showError(visible)
    override fun showErrorFatherName(visible: Boolean) = nameFatherField.showError(visible)
    override fun showErrorPhoneNumber(visible: Boolean) = phoneField.showError(visible)

    private fun setListeners() {
        nameFirstField.addTextChangedListener(AfterTextChangedWatcher {
            presenter.setOrderFirstName(it.toString())
        })
        nameLastField.addTextChangedListener(AfterTextChangedWatcher {
            presenter.setOrderLastName(it.toString())
        })
        nameFatherField.addTextChangedListener(AfterTextChangedWatcher {
            presenter.setOrderFatherName(it.toString())
        })
        phoneField.addTextChangedListener(AfterTextChangedWatcher {
            presenter.setOrderPhoneNumber(it.toString())
        })
        buttonOrderGoBack.setOnClickListener { finish() }
    }

    companion object {
        const val BASKET_TAG = "BASKET_TAG"
    }

}

fun EditText.showError(visible: Boolean) {
    val drawable = if (visible) R.drawable.ic_error_red_24dp else 0
    this.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0)
}
