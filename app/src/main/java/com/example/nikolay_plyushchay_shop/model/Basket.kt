package com.example.nikolay_plyushchay_shop.model

class Basket(
    val products: List<Product> = emptyList()
) {
    val discountPrice: Double = products.map { product -> product.discountPrice }.sum()
}

