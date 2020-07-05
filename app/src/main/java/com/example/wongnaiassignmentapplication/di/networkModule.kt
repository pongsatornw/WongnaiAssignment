package com.example.wongnaiassignmentapplication.di

import com.example.wongnaiassignmentapplication.api.APIService
import com.example.wongnaiassignmentapplication.api.ApiInterceptor
import com.example.wongnaiassignmentapplication.api.CustomOkHttpClient
import com.example.wongnaiassignmentapplication.api.RetrofitManager
import org.koin.dsl.module
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single { ApiInterceptor().getInterceptor() }
    single { CustomOkHttpClient().create(interceptor = get()) }
    single { RetrofitManager(client = get(), converter = MoshiConverterFactory.create()) }
    single<APIService> { get<RetrofitManager>().create(baseUrl = "https://api.coinranking.com/v1/") }
}