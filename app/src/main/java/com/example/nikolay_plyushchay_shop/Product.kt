package com.example.nikolay_plyushchay_shop

class Product(
    val name: String,
    private val price: Double,
    private val salePercent: Int = 0
) {
    init {
        if (price < 0.0) throw VerifyError("Price must be positive")
        if (salePercent > 100) throw VerifyError("Sale percent can't be more than 100")
    }

    val discountPrice: Double = price * (1 - salePercent / 100.0)
}

class ProductPresenter(
    override val view: View,
    val product: Product
) : Presenter {
    override fun print() = view.print(format(product.discountPrice))
}
