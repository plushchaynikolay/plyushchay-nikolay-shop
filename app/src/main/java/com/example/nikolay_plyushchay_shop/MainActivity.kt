package com.example.nikolay_plyushchay_shop

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BaseView {
    private val presenter = BucketPresenter(
        bucket = Bucket(
            listOf(
                Product(name = "IPhone", price = 123.5, salePercent = 30),
                Product(name = "Samsung", price = 85.5, salePercent = 20),
                Product(name = "Xiomi", price = 50.5, salePercent = 10)
            )
        ),
        order = OrderModel()
    )

    override fun print(msg: String) {
        textViewOrderInfo.text = msg
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
    }
}

fun EditText.showError(visible: Boolean) {
    val drawable = if (visible) R.drawable.ic_error_red_24dp else 0
    this.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0)
}
