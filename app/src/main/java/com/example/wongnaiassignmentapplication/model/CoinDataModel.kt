package com.example.wongnaiassignmentapplication.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class CoinDataModel(
    @field:Json(name="base") val base: BaseModel,
    @field:Json(name="coins") val coins: List<CoinModel>,
    @field:Json(name="stats") val stats: StatsModel
)