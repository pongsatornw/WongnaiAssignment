package com.example.wongnaiassignmentapplication.api

import okhttp3.Interceptor

class ApiInterceptor {

    fun getInterceptor() = Interceptor {
        val original = it.request()
        it.proceed(original.newBuilder().run {
            addHeader("OS", "Android")
            addHeader("Version", " BuildConfig.VERSION_NAME")
            build()
        })
    }

}