package com.android.personal_project_kakaobank_a.retrofit

import com.android.personal_project_kakaobank_a.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader(
                "Authorization",
                BuildConfig.REST_API_KEY
            ).build()
        return chain.proceed(newRequest)
    }
}