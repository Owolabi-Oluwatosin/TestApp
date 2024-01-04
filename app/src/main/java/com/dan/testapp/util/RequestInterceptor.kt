package com.dan.testapp.util

import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor: Interceptor {
    private val authToken: String? = null
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "Bearer $authToken")
            .build()
        return chain.proceed(request)
    }
}