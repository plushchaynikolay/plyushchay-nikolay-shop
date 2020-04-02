package com.example.nikolay_plyushchay_shop

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    fun formatPrice(price: Double, measure: String = "шт.", discount: Int = 0) {
        var result = ""
        val priceWithDiscount = price * (1 - discount / 100)
        if (priceWithDiscount % 1.0 > 0) {
            result += String.format("%.2f", priceWithDiscount)
        } else {
            result += priceWithDiscount.toUInt()
        }
        result = "$result/$measure"
        if (discount > 0) {
            result = "$result (скидка $discount%)"
        }
        println(result)
    }

    @Test
    fun addition_isCorrect() {
        formatPrice(134.0, discount = 15)
    }
}
