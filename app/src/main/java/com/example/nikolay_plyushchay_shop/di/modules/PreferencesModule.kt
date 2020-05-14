package com.example.nikolay_plyushchay_shop.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.example.nikolay_plyushchay_shop.data.SharedPreferencesBasketDao
import com.example.nikolay_plyushchay_shop.domain.BasketProductDao
import dagger.Module
import dagger.Provides

@Module
class PreferencesModule {
    @Provides
    fun providePreferences(context: Context): SharedPreferences =
        context.getSharedPreferences("data", Context.MODE_PRIVATE)

    @Provides
    fun provideBasketProduct(preferences: SharedPreferences): BasketProductDao =
        SharedPreferencesBasketDao(preferences)
}