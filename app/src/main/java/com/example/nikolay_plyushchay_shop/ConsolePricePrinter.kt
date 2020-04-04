package com.example.nikolay_plyushchay_shop

class ConsolePricePrinter : PricePrinter {
    override fun print(product: Product) {
        println(format(product.calcDiscountPrice()))
    }

    override fun print(bucket: Bucket) {
        bucket.products.forEach(this::print)
        print("Сумма (со скидкой): ${format(bucket.calcDiscountPrice())}")
    }

    private fun format(price: Double): String {
        val digits: Int = if (price % 1 > 0) 2 else 0
        return "%.${digits}f".format(price)
    }
}