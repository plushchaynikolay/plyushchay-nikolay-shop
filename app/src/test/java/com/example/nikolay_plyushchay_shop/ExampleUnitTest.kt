package com.example.nikolay_plyushchay_shop

import org.junit.Test
import org.junit.Assert.*

class ExampleUnitTest {
    @Test
    fun example() {
        val iphoneCase = Product(price = 123.5, salePercent = 30)
        val pricePrinter: PricePrinter = ConsolePricePrinter()
        val discountIphoneCasePrice = iphoneCase.calcDiscountPrice()
        pricePrinter.print(discountIphoneCasePrice)
    }
}