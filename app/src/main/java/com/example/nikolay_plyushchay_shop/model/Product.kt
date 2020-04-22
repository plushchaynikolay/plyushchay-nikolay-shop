package com.example.nikolay_plyushchay_shop.model

class Product(
    val name: String,
    val price: Double,
    val discount: Int = 0,
    val description: String = ""
) {
    init {
        if (price < 0.0) throw VerifyError("Price must be positive")
        if (discount > 100) throw VerifyError("Sale percent can't be more than 100")
    }

    val discountPrice: Double = price * (1 - discount / 100.0)
}
