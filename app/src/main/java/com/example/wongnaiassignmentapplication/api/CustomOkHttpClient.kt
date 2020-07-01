package com.example.wongnaiassignmentapplication.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class CustomOkHttpClient {

    fun create(interceptor: Interceptor): OkHttpClient = with(OkHttpClient.Builder()){
        addInterceptor(interceptor)
        addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        return@with build()
    }

}