package com.example.nikolay_plyushchay_shop

interface View {
    fun print(msg: String)
}

class ConsoleView : View {
    override fun print(msg: String) = println(msg)
}
