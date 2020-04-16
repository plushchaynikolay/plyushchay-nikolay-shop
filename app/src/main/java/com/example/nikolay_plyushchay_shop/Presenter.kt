package com.example.nikolay_plyushchay_shop

import moxy.MvpPresenter
import kotlin.math.round

abstract class Presenter : MvpPresenter<BaseView>(){
    abstract fun print()
}

fun format(price: Double): String {
    val roundedPrice = round(100.0 * price) / 100.0
    val digits: Int = if (roundedPrice % 1 > 0) 2 else 0
    return "%.${digits}f".format(roundedPrice)
}
