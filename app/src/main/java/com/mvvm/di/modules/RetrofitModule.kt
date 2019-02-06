package com.mvvm.di.modules

import android.app.Application
import android.support.annotation.NonNull
import android.support.constraint.solver.Cache
import com.mvvm.repository.remote.ApiHelper
import com.mvvm.repository.remote.Utils.RequestInterceptor
import com.mvvm.repository.remote.Utils.ScalarGsonConvertorFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.jetbrains.annotations.NotNull
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
@Module
class RetrofitModule{
    private val BASE_URL = "https://www.fcjamshedpur.com/"
    private val READ_TIMEOUT_SECONDS = 60
    private val WRITE_TIMEOUT_SECONDS = 60
    private val CONNECT_TIMEOUT_SECONDS = 10
    private val CACHE_50MB = 50 * 1024 * 1024L

    @Provides
    @Singleton
    @NonNull
    fun provideOkHttp(dataCache: okhttp3.Cache, httpLoggingInterceptor: HttpLoggingInterceptor, requestInterceptor: RequestInterceptor): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .cache(dataCache)
            .connectTimeout(CONNECT_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(requestInterceptor)

    }

    @Provides
    @Singleton
    @NonNull
    fun provideRetrofit(httpClient: OkHttpClient.Builder): Retrofit {

        //add retro builder
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build()).build()
    }

    @Provides
    @Singleton
    @NonNull
    fun provideDataCache(context: Application): okhttp3.Cache = okhttp3.Cache(context.cacheDir, CACHE_50MB)


    @Provides
    @Singleton
    @NonNull
    fun provideHttpLogger(): HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)

    @Provides
    @Singleton
    fun provideItemService(retrofit: Retrofit): ApiHelper {
        return retrofit.create(ApiHelper::class.java)
    }

    @Provides
    @Singleton
    fun provideCustomInterceptor() = RequestInterceptor()

}