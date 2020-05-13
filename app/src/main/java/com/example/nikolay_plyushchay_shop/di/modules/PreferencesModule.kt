package com.example.nikolay_plyushchay_shop.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.example.nikolay_plyushchay_shop.data.ViewedProductDaoImpl
import com.example.nikolay_plyushchay_shop.domain.ViewedProductDao
import dagger.Module
import dagger.Provides

@Module
class PreferencesModule {
    @Provides
    fun providePreferences(context: Context): SharedPreferences =
        context.getSharedPreferences("data", Context.MODE_PRIVATE)

    @Provides
    fun provideViewedProduct(preferences: SharedPreferences): ViewedProductDao =
        ViewedProductDaoImpl(preferences)
}