package com.example.nikolay_plyushchay_shop.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.example.nikolay_plyushchay_shop.R
import com.example.nikolay_plyushchay_shop.model.Basket
import com.example.nikolay_plyushchay_shop.model.Order
import com.example.nikolay_plyushchay_shop.model.Product
import com.example.nikolay_plyushchay_shop.presenter.OrderPresenter
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : BaseActivity(),
    OrderView {
    private val presenter = OrderPresenter(
        Basket(
            mutableListOf(
                Product("IPhone", 123.5, 30),
                Product("Samsung", 85.5, 20),
                Product("Xiomi", 50.5, 10)
            )
        ),
        Order()
    )

    override fun print(msg: String) {
        textViewOrderInfo.text = msg
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        presenter.attachView(this)
        setListeners()
        presenter.print()
    }

    override fun showErrorFirstName(visible: Boolean) = nameFirstField.showError(visible)
    override fun showErrorLastName(visible: Boolean) = nameLastField.showError(visible)
    override fun showErrorFatherName(visible: Boolean) = nameFatherField.showError(visible)
    override fun showErrorPhoneNumber(visible: Boolean) = phoneField.showError(visible)

    private fun setListeners() {
        nameFirstField.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {
                presenter.setOrderFirstName(s.toString())
            }
        })
        nameLastField.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {
                presenter.setOrderLastName(s.toString())
            }
        })
        nameFatherField.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {
                presenter.setOrderFatherName(s.toString())
            }
        })
        phoneField.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {
                presenter.setOrderPhoneNumber(s.toString())
            }
        })
        buttonOrderGoBack.setOnClickListener { finish() }
    }
}

fun EditText.showError(visible: Boolean) {
    val drawable = if (visible) R.drawable.ic_error_red_24dp else 0
    this.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0)
}