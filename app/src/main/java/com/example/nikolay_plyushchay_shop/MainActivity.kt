package com.example.nikolay_plyushchay_shop

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.print()
    }
}
