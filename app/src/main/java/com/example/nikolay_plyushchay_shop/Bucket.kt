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
        bucket.products.forEach { product ->
            view.print("${product.name}: ${format(product.discountPrice)}")
        }
        view.print(format(bucket.discountPrice))
    }
}