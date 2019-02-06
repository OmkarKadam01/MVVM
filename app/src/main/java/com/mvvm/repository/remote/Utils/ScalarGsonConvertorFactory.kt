package com.mvvm.repository.remote.Utils

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.lang.reflect.Type

class ScalarGsonConvertorFactory : Converter.Factory() {

    private val scalarFactory = ScalarsConverterFactory.create()
    private val gsonFactory = GsonConverterFactory.create()

    override fun responseBodyConverter(type: Type?, annotations: Array<Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *>? {
        for (annotation in annotations!!) {

            if (annotation.annotationClass == Scalar::class.java) {
                return scalarFactory.responseBodyConverter(type, annotations, retrofit)
            }

            if (annotation.annotationClass == Gson::class.java) {
                return gsonFactory.responseBodyConverter(type, annotations, retrofit)
            }

        }
        return null
    }
}