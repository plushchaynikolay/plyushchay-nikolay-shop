package com.example.nikolay_plyushchay_shop.domain.model

class Basket(
    val products: MutableList<Product> = mutableListOf()
) {
    fun getPrice(): Double = products.map { product -> product.price }.sum()
    fun getDiscountPrice(): Double = products.map { product -> product.discountPrice }.sum()
}
