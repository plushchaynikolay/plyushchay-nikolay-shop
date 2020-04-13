package com.example.nikolay_plyushchay_shop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View {
    private val presenter: Presenter = BucketPresenter(
        view = this,
        bucket = Bucket(
            listOf(
                Product(name = "IPhone", price = 123.5, salePercent = 30),
                Product(name = "Samsung", price = 85.5, salePercent = 20),
                Product(name = "Xiomi", price = 50.5, salePercent = 10)
            )
        )
    )

    override fun print(msg: String) {
        textViewOrderInfo.text = msg
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.print()
    }
}
