package com.mvvm.di.components

import android.app.Application
import com.mvvm.MyApplication
import com.mvvm.di.ActivityBuilder
import com.mvvm.di.modules.AppModule
import com.mvvm.di.modules.RetrofitModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, RetrofitModule::class, ActivityBuilder:: class))
interface  AppComponent {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(app:Application): Builder
        fun build(): AppComponent
    }
    fun inject(app: MyApplication)
}