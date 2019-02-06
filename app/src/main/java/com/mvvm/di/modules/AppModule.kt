package com.mvvm.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.mvvm.di.qualifiers.PreferenceInfo
import com.mvvm.ui.base.ViewState
import com.mvvm.ui.base.SingleLiveEvent
import dagger.Module
import dagger.Provides
import com.mvvm.repository.DataManager
import com.mvvm.repository.DataManagerContract
import com.mvvm.repository.local.prefs.ApplicationPreferences
import com.mvvm.repository.local.prefs.PreferencesHelper
import com.mvvm.utils.APPLICATION_PREFERENCE_NAME
import com.mvvm.utils.rx.AppSchedulerProvider
import com.mvvm.utils.rx.SchedulerProvider
import javax.inject.Singleton

@Module
class AppModule{
    @Provides
    @Singleton
    fun ProvideApplication(context: Application): Context = context

    @Provides
    fun provideSingleEvent(): SingleLiveEvent<ViewState> = SingleLiveEvent()

    @Provides
    @Singleton
    fun provideDataManeger(appDataManager: DataManager): DataManagerContract {
        return appDataManager
    }
    @Provides
    @PreferenceInfo
    fun providePreferenceName():String {
        return APPLICATION_PREFERENCE_NAME
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferencesHelper: ApplicationPreferences): PreferencesHelper {
        return appPreferencesHelper

    }

    @Provides
    @Singleton
    fun provideSharePreferences(context: Context,@PreferenceInfo prefFileName:String): SharedPreferences? {
        return context.getSharedPreferences(prefFileName,Context.MODE_PRIVATE)
    }
    @Provides
    @Singleton
    fun provideScedulerProvider(): SchedulerProvider = AppSchedulerProvider()


}