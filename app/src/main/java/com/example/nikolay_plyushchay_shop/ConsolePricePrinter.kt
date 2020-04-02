package com.example.nikolay_plyushchay_shop

class ConsolePricePrinter: PricePrinter{
    override fun print(price: Double) {
        println(price.toString())
    }
}