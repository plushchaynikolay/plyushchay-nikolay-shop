package com.example.nikolay_plyushchay_shop

import org.junit.Test

class ExampleUnitTest {
    @Test
    fun test_Product() {
        val iphoneCase = Product(name = "IPhone", price = 123.5, salePercent = 30)
        val view: View = ConsoleView()
        val iphonePresenter = ProductPresenter(product = iphoneCase, view = view)
        iphonePresenter.print()
    }

    @Test
    fun test_Bucket() {
        val iphoneCase = Product(name = "IPhone", price = 123.5, salePercent = 30)
        val samsungCase = Product(name = "Samsung", price = 85.5, salePercent = 20)
        val xiomiCase = Product(name = "Xiomi", price = 50.5, salePercent = 10)
        val productList: List<Product> = listOf(iphoneCase, samsungCase, xiomiCase)
        val bucket = Bucket(productList)
        val view: View = ConsoleView()
        val bucketPresenter = BucketPresenter(view, bucket)
        bucketPresenter.print()
    }

    @Test
    fun test_emptyBucket() {
        val bucket = Bucket()
        val view: View = ConsoleView()
        val bucketPresenter = BucketPresenter(view, bucket)
        bucketPresenter.print()
    }
}
