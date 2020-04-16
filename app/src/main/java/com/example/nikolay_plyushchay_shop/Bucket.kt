package com.example.nikolay_plyushchay_shop

class Bucket(
    val products: List<Product> = emptyList()
) {
    val discountPrice: Double = products.map { product -> product.discountPrice }.sum()
}

class BucketPresenter(
    private val bucket: Bucket,
    private val order: OrderModel
) : Presenter() {
    override fun print() {
        var presentation = ""
        bucket.products.forEach { p ->
            presentation += "${p.name}: ${format(p.price)}/${p.salePercent}% = ${format(p.discountPrice)}\n"
        }
        presentation += format(bucket.discountPrice)
        viewState.print(presentation)
    }

    fun setOrderFirstName(s: String) {
        if (s.length > 2) {
            order.firstName = s
            viewState.showErrorFirstName(false)
        } else viewState.showErrorFirstName(true)
    }

    fun setOrderLastName(s: String) {
        if (s.length > 2) {
            order.firstName = s
            viewState.showErrorLastName(false)
        } else viewState.showErrorLastName(true)
    }

    fun setOrderFatherName(s: String) {
        if (s.length > 2) {
            order.firstName = s
            viewState.showErrorFatherName(false)
        } else viewState.showErrorFatherName(true)
    }

    fun setOrderPhoneNumber(s: String) {
        if (Regex("(\\+7|8)\\d{10}").matches(s)) {
            order.firstName = s
            viewState.showErrorPhoneNubmer(false)
        } else viewState.showErrorPhoneNubmer(true)
    }
}
