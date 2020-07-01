package com.example.wongnaiassignmentapplication.api

import retrofit2.http.*

interface APIService {

    @GET("v1/public/coins")
    suspend fun getCoins()

}