package com.example.nikolay_plyushchay_shop.domain

import com.example.nikolay_plyushchay_shop.domain.model.Product

interface BasketProductDao {
    fun addProduct(product: Product)
    fun getAllProducts(): List<Product>
}
