package com.example.wongnaiassignmentapplication.module.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.wongnaiassignmentapplication.common.base.BaseViewModel
import com.example.wongnaiassignmentapplication.model.CoinModel
import com.example.wongnaiassignmentapplication.module.main.CoinDataSourceFactory
import com.example.wongnaiassignmentapplication.repository.base.CoinRepository
import kotlinx.coroutines.launch

class MainViewModel(private val coinRepository: CoinRepository): BaseViewModel() {


    val coinList: LiveData<PagedList<CoinModel>>
    val factory: CoinDataSourceFactory

    init  {
        val config = PagedList.Config.Builder()
            .setPageSize(10)
            .setEnablePlaceholders(false)
            .build()

        factory =
            CoinDataSourceFactory(
                coinRepository,
                viewModelScope
            )

        coinList = LivePagedListBuilder(factory, config).build()
        println("OKHTTP START")
    }

    fun callGetCoins() = viewModelScope.launch {
        factory.dataSourceLiveData.value?.invalidate()
    }



}