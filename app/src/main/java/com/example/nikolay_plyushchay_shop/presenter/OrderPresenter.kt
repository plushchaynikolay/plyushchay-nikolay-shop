package com.example.nikolay_plyushchay_shop.presenter

import com.example.nikolay_plyushchay_shop.domain.BasketProductDao
import com.example.nikolay_plyushchay_shop.domain.model.Basket
import com.example.nikolay_plyushchay_shop.domain.model.Order
import com.example.nikolay_plyushchay_shop.utils.format
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class OrderPresenter @Inject constructor(
    private val basketProductDao: BasketProductDao
) : BasePresenter<OrderView>() {
    private val order = Order()
    private val basket: Basket = Basket(basketProductDao.getAllProducts().toMutableList())

    fun clearBasket() =
        basket.products.forEach {
            basketProductDao.removeProduct(it)
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
