package com.example.nikolay_plyushchay_shop

import org.junit.Test
import org.junit.Assert.*

class ExampleUnitTest {
    @Test
    fun test_Product() {
        val iphoneCase = Product(price = 123.5, salePercent = 30)
        val pricePrinter: PricePrinter = ConsolePricePrinter()
        pricePrinter.print(iphoneCase)
    }

    @Test
    fun test_Bucket() {
        val iphoneCase = Product(price = 123.5, salePercent = 30)
        val samsungCase = Product(price = 85.5, salePercent = 20)
        val xiomiCase = Product(price = 50.5, salePercent = 10)
        val productList: List<Product> = listOf(iphoneCase, samsungCase, xiomiCase)
        val bucket = Bucket(productList)
        val pricePrinter: PricePrinter = ConsolePricePrinter()
        pricePrinter.print(bucket)
    }
}