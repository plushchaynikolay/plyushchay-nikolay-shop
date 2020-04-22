package com.example.nikolay_plyushchay_shop.presenter

import com.example.nikolay_plyushchay_shop.model.Basket
import com.example.nikolay_plyushchay_shop.model.Order
import com.example.nikolay_plyushchay_shop.ui.OrderView
import moxy.MvpPresenter

class OrderPresenter(
    private val basket: Basket,
    private val order: Order
) : MvpPresenter<OrderView>() {
    fun print() {
        var presentation = ""
        basket.products.forEach { p ->
            presentation += "${p.name}: ${format(
                p.price
            )}/${p.discount}% = ${format(
                p.discountPrice
            )}\n"
        }
        presentation += format(
            basket.getDiscountPrice()
        )
        viewState.print(presentation)
    }

    fun setOrderFirstName(s: String) {
        if (s.length > 2) {
            order.firstName = s
            viewState.showErrorFirstName(false)
        } else viewState.showErrorFirstName(true)
    }

    fun setOrderLastName(s: String) {
        if (s.length > 2) {
            order.lastName = s
            viewState.showErrorLastName(false)
        } else viewState.showErrorLastName(true)
    }

    fun setOrderFatherName(s: String) {
        if (s.length > 2) {
            order.fatherName = s
            viewState.showErrorFatherName(false)
        } else viewState.showErrorFatherName(true)
    }

    fun setOrderPhoneNumber(s: String) {
        if (Regex("(\\+7|8)\\d{10}").matches(s)) {
            order.phoneNumber = s
            viewState.showErrorPhoneNumber(false)
        } else viewState.showErrorPhoneNumber(true)
    }
}
