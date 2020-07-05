package com.example.wongnaiassignmentapplication.module.main

import androidx.paging.PositionalDataSource
import com.example.wongnaiassignmentapplication.model.CoinModel
import com.example.wongnaiassignmentapplication.repository.base.CoinRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CoinDataSource(private val repository: CoinRepository, private val coroutine: CoroutineScope): PositionalDataSource<CoinModel>() {

    var offset = 0

    override fun loadRange(
        params: LoadRangeParams,
        callback: LoadRangeCallback<CoinModel>
    ) {


        coroutine.launch {
            val result = repository.getCoins(offset = params.startPosition)

                if(result.data?.coins != null) {
                    callback.onResult(result.data.coins)
                } else {
                    callback.onResult(listOf<CoinModel>())
                }


            offset = (result.data?.stats?.offset?:0) + (result.data?.stats?.perPage?:0)

        }

    }

    override fun loadInitial(
        params: LoadInitialParams,
        callback: LoadInitialCallback<CoinModel>
    ) {

        runBlocking {
            val result = repository.getCoins()

            if(result.data?.coins != null) {
                callback.onResult(result.data.coins, params.requestedStartPosition)
            } else {
                callback.onResult(listOf<CoinModel>(), params.requestedStartPosition)
            }

            offset = (result.data?.stats?.offset?:0) + (result.data?.stats?.perPage?:0)


            result
        }



    }

}