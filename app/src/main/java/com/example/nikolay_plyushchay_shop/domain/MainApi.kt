package com.example.nikolay_plyushchay_shop.domain

import retrofit2.http.GET
import retrofit2.http.Path

interface MainApi {
    @GET("products/all/{author}")
    suspend fun allProducts(@Path("author") author: String = "default"): List<RemoteProduct>
}