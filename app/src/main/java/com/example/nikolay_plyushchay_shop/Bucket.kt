package com.example.nikolay_plyushchay_shop

class Bucket(
    val products: List<Product> = emptyList()
) {
    val discountPrice: Double = products.map { product -> product.discountPrice }.sum()
}

class BucketPresenter(
    override val view: View,
    private val bucket: Bucket
) : Presenter {
    override fun print() {
        var presentation = ""
        bucket.products.forEach { product ->
            presentation += "${product.name}: ${format(product.discountPrice)}\n"
        }
        presentation += format(bucket.discountPrice)
        view.print(presentation)
    }
}