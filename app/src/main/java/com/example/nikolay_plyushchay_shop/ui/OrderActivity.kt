package com.example.nikolay_plyushchay_shop.ui

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.graphics.drawable.toDrawable
import com.example.nikolay_plyushchay_shop.App
import com.example.nikolay_plyushchay_shop.R
import com.example.nikolay_plyushchay_shop.presenter.OrderPresenter
import com.example.nikolay_plyushchay_shop.presenter.OrderView
import com.example.nikolay_plyushchay_shop.utils.AfterTextChangedWatcher
import kotlinx.android.synthetic.main.activity_order.*
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class OrderActivity : BaseActivity(), OrderView {
    @Inject
    lateinit var orderPresenter: OrderPresenter
    private val presenter by moxyPresenter { orderPresenter }

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
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
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
        buttonAcceptOrder.setOnClickListener {
            presenter.clearBasket()
            DialogFragment(
                "Заказ успешно оформлен",
                R.drawable.ic_done_24dp.toDrawable(),
                "OK"
            ) { finish() }
                .show(supportFragmentManager, "dialog")
        }
    }
}

fun EditText.showError(visible: Boolean) {
    val drawable = if (visible) R.drawable.ic_error_red_24dp else 0
    this.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0)
}
