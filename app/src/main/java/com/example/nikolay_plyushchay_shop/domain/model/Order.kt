package com.example.nikolay_plyushchay_shop.domain.model

data class Order(
    var firstName: String = "",
    var lastName: String = "",
    var fatherName: String = "",
    var phoneNumber: String = "",
    var payment: Payment = Payment.CARD
)
