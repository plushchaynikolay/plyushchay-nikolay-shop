package com.example.nikolay_plyushchay_shop.data

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.nikolay_plyushchay_shop.domain.ViewedProductDao

class ViewedProductDaoImpl(
    private val sharedPreferences: SharedPreferences
) : ViewedProductDao {

    private var savedProductIds: List<Long>
        get() = sharedPreferences.getString(PRODUCT_TAG, null)
            ?.split(",")
            ?.mapNotNull { it.toLongOrNull() } ?: emptyList()
        set(value) {
            sharedPreferences.edit {
                putString(PRODUCT_TAG, value.joinToString(","))
            }
        }

    override fun getAllProducts(): List<Long> = savedProductIds
    override fun addProduct(productId: Long) {
        val productIds: List<Long> = savedProductIds
        val newProductIds = mutableListOf<Long>().apply {
            add(productId)
            addAll(productIds.filter { it != productId })
        }
        savedProductIds = newProductIds
    }

    companion object {
        private const val PRODUCT_TAG = "PRODUCT_TAG"
    }
}