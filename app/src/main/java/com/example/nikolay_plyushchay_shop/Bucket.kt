package com.example.nikolay_plyushchay_shop

class Bucket(
    val products: List<Product> = emptyList<Product>()
) {
    fun calcDiscountPrice(): Double = products.map { product -> product.calcDiscountPrice() }.sum()
}