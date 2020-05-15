package com.example.nikolay_plyushchay_shop.data

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.nikolay_plyushchay_shop.domain.BasketProductDao
import com.example.nikolay_plyushchay_shop.domain.model.Product
import com.google.gson.Gson

class SharedPreferencesBasketDao(
    private val sharedPreferences: SharedPreferences
) : BasketProductDao {

    private var savedProducts: List<Product>
        get() = sharedPreferences.getString(PRODUCT_TAG, null)
            ?.split(DELIMITER)
            ?.mapNotNull {
                Gson().fromJson(it, Product::class.java)
            } ?: emptyList()
        set(value) {
            sharedPreferences.edit {
                putString(PRODUCT_TAG, value.joinToString(DELIMITER) { Gson().toJson(it) })
            }
        }

    override fun getAllProducts(): List<Product> = savedProducts

    override fun addProduct(product: Product) {
        val products: List<Product> = savedProducts
        val newProducts = mutableListOf<Product>().apply {
            addAll(products)
            add(product)
        }
        savedProducts = newProducts
    }

    override fun removeProduct(product: Product) {
        val products: List<Product> = savedProducts
        val newProducts = mutableListOf<Product>().apply {
            addAll(products)
            remove(this.last { it.id == product.id })
        }
        savedProducts = newProducts
    }

    companion object {
        private const val PRODUCT_TAG = "PRODUCT_TAG"
        private const val DELIMITER = ";"
    }
}