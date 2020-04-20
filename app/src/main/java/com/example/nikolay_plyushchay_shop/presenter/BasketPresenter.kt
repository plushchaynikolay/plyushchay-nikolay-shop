package com.example.nikolay_plyushchay_shop.presenter

import com.example.nikolay_plyushchay_shop.ui.BasketView
import moxy.MvpPresenter

class BasketPresenter : MvpPresenter<BasketView>() {
    private val list = mutableListOf<String>("Пони 1", "Пони 2", "Пони 3")

    fun setItems() {
        viewState.setItems(list)
    }

    fun removeItem(name: String) {
        val position = list.indexOf(name)
        list.removeAt(position)
        viewState.removeItem(position)
    }
}