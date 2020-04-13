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
        bucket.products.forEach { p ->
            presentation += "${p.name}: ${format(p.price)}/${p.salePercent}% = ${format(p.discountPrice)}\n"
        }
        presentation += format(bucket.discountPrice)
        view.print(presentation)
    }
}