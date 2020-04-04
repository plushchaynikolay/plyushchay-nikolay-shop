package com.example.nikolay_plyushchay_shop

class ConsolePricePrinter: PricePrinter{
    override fun print(price: Double) {
        val digits = if (price % 1 > 0) 2 else 0
        println("Цена (со скидкой): %.${digits}f".format(price))
    }
}