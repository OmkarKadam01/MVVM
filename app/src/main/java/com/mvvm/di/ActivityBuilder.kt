package com.mvvm.di

import com.mvvm.di.scopes.PerActivity
import com.mvvm.ui.landing.LandingActivity
import com.mvvm.ui.landing.LandingActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = arrayOf(
        LandingActivityModule::class
    ))
    @PerActivity
    abstract fun bindLandingActivity(): LandingActivity


//    @ContributesAndroidInjector(modules = arrayOf(SplashActivityModule::class))
//    internal abstract fun bindLoginActivity(): SplashActivity
}