package com.mvvm.repository.remote.Utils
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class RequestInterceptor ():Interceptor  {


    override fun intercept(chain: Interceptor.Chain?): Response? {

        val response = chain?.proceed(chain.request())


        return response
    }
}