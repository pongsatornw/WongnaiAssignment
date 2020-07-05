package com.example.wongnaiassignmentapplication.api

import com.example.wongnaiassignmentapplication.model.CoinDataModel
import com.example.wongnaiassignmentapplication.model.base.BaseResult
import retrofit2.Call
import retrofit2.http.*

interface APIService {

    @GET("public/coins")
    suspend fun getCoins(
        @Query("limit") limit: Int = 10,
        @Query("offset") offset: Int = 0
    ): BaseResult<CoinDataModel>

    @GET("public/coins")
    fun getCoinsV2(
        @Query("limit") limit: Int = 10,
        @Query("offset") offset: Int = 0
    ): Call<BaseResult<CoinDataModel>>

}