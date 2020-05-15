package com.example.nikolay_plyushchay_shop.presenter

import com.example.nikolay_plyushchay_shop.domain.model.Basket
import com.example.nikolay_plyushchay_shop.domain.model.Order
import moxy.InjectViewState

@InjectViewState
class OrderPresenter : BasePresenter<OrderView>() {
    private val order = Order()
    private lateinit var basket: Basket

    fun setBasket(basket: Basket) {
        this.basket = basket
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        printBasketInfo()
    }

    private fun printBasketInfo() {
        val totalPrice = basket.getDiscountPrice()
        val totalDiscount = basket.getPrice() - totalPrice
        viewState.printTotal(
            format(basket.getDiscountPrice()),
            basket.products.count().toString(),
            if (totalDiscount > 0.0) {
                format(totalDiscount)
            } else null
        )
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
