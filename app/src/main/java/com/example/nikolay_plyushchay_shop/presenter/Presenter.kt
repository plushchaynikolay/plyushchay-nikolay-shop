package com.example.nikolay_plyushchay_shop.presenter

import moxy.MvpPresenter
import kotlin.math.round

/**
 * Базовый класс для всех классов Presenter.
 *
 * TODO(Использовать базовый View вместо OrderView)
 */
abstract class Presenter : MvpPresenter<OrderView>() {
    abstract fun print()
}

fun format(price: Double): String {
    val roundedPrice = round(100.0 * price) / 100.0
    val digits: Int = if (roundedPrice % 1 > 0) 2 else 0
    return "%.${digits}f".format(roundedPrice)
}
