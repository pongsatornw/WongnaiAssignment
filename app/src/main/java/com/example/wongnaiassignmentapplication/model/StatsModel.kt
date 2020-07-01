package com.example.wongnaiassignmentapplication.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class StatsModel(
    @field:Json(name = "base") val base: String,
    @field:Json(name = "limit") val perPage: Int,
    @field:Json(name = "offset") val offset: Int,
    @field:Json(name = "order") val order: String,
    @field:Json(name = "total") val total: Int,
    @field:Json(name = "total24hVolume") val total24hVolume: Double,
    @field:Json(name = "totalExchanges") val totalExchanges: Int,
    @field:Json(name = "totalMarketCap") val totalMarketCap: Double,
    @field:Json(name = "totalMarkets") val totalMarkets: Int
)
