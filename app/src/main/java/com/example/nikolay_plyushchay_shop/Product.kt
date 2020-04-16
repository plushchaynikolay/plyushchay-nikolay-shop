package com.example.nikolay_plyushchay_shop

class Product(
    val name: String,
    val price: Double,
    val salePercent: Int = 0
) {
    init {
        if (price < 0.0) throw VerifyError("Price must be positive")
        if (salePercent > 100) throw VerifyError("Sale percent can't be more than 100")
    }

    val discountPrice: Double = price * (1 - salePercent / 100.0)
}

class ProductPresenter(
    val product: Product
) : Presenter() {
    override fun print() = viewState.print(format(product.discountPrice))
}
