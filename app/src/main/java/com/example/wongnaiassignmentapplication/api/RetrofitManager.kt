package com.example.wongnaiassignmentapplication.api

import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit

class RetrofitManager(
    val client: OkHttpClient,
    val converter: Converter.Factory)
{

    inline fun<reified T> create(baseUrl: String): T = Retrofit.Builder().run {
        baseUrl(baseUrl)
        addConverterFactory(converter)
        client(client)
        build()
    }.create(T::class.java)

}