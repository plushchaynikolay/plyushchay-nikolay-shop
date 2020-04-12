package com.example.nikolay_plyushchay_shop

import kotlin.math.round

interface Presenter {
    val view: View
    fun print()
}

fun format(price: Double): String {
    val roundedPrice = round(100.0 * price) / 100.0
    val digits: Int = if (roundedPrice % 1 > 0) 2 else 0
    return "%.${digits}f".format(roundedPrice)
}
