package com.example.wongnaiassignmentapplication.model

data class CoinDataModel(
    val base: BaseModel,
    val coins: List<CoinModel>,
    val stats: StatsModel
)