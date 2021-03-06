package com.example.nikolay_plyushchay_shop.di

import android.content.Context
import com.example.nikolay_plyushchay_shop.di.modules.MainApiModule
import com.example.nikolay_plyushchay_shop.di.modules.PreferencesModule
import com.example.nikolay_plyushchay_shop.ui.BasketActivity
import com.example.nikolay_plyushchay_shop.ui.CatalogActivity
import com.example.nikolay_plyushchay_shop.ui.OrderActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        PreferencesModule::class,
        MainApiModule::class
    ]
)
@Singleton
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }

    fun inject(activity: CatalogActivity)
    fun inject(activity: BasketActivity)
    fun inject(activity: OrderActivity)
}