package com.example.nikolay_plyushchay_shop.domain

data class RemoteProduct(
    val name: String,
    val price: Double,
    val discount: Int,
    val description: String,
    val imageUrl: String,
    val attributes: List<Attribute>,
    val id: String
) {
    data class Attribute(
        val name: String,
        val value: String
    )
}