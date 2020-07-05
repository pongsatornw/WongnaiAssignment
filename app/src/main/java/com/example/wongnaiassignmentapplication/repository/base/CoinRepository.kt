package com.example.wongnaiassignmentapplication.repository.base

import com.example.wongnaiassignmentapplication.model.CoinDataModel
import com.example.wongnaiassignmentapplication.model.base.BaseResult

interface CoinRepository {

    suspend fun getCoins(offset: Int = 0): BaseResult<CoinDataModel>

}