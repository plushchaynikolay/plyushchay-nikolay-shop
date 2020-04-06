package com.example.nikolay_plyushchay_shop

class Product(
    private val price: Double,
    private val salePercent: Int = 0
) {
    init {
        if (price < 0.0) throw VerifyError("Price must be positive")
        if (salePercent > 100) throw VerifyError("Sale percent can't be more than 100")
    }

    /**
     * @return price with applied discount determined by [salePercent]
     */
    fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)
}
