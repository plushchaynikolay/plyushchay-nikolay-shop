package com.example.nikolay_plyushchay_shop.domain

interface ViewedProductDao {
    fun addProduct(productId: Long)
    fun getAllProducts(): List<Long>
}
