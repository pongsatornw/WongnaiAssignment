package com.example.wongnaiassignmentapplication.module.main

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.wongnaiassignmentapplication.model.CoinModel
import com.example.wongnaiassignmentapplication.module.main.CoinDataSource
import com.example.wongnaiassignmentapplication.repository.base.CoinRepository
import kotlinx.coroutines.CoroutineScope


class CoinDataSourceFactory(private val repository: CoinRepository, private val coroutine: CoroutineScope) : DataSource.Factory<Int, CoinModel>() {

    var dataSourceLiveData: MutableLiveData<CoinDataSource> =
        MutableLiveData<CoinDataSource>()

    override fun create(): DataSource<Int, CoinModel> {
        val dataSource : CoinDataSource =
            CoinDataSource(
                repository,
                coroutine
            )
        dataSourceLiveData.postValue(dataSource)
        return dataSource
    }


}