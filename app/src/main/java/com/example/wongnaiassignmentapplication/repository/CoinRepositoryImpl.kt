package com.example.wongnaiassignmentapplication.repository

import com.example.wongnaiassignmentapplication.api.APIService
import com.example.wongnaiassignmentapplication.model.CoinDataModel
import com.example.wongnaiassignmentapplication.model.base.BaseResult
import com.example.wongnaiassignmentapplication.repository.base.CoinRepository

class CoinRepositoryImpl(private val api: APIService): CoinRepository {
    override suspend fun getCoins(offset: Int): BaseResult<CoinDataModel> {
        return api.getCoins(offset = offset)
    }
}