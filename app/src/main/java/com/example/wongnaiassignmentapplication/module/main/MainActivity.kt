package com.example.wongnaiassignmentapplication.module.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wongnaiassignmentapplication.common.base.BaseActivity
import com.example.wongnaiassignmentapplication.databinding.ActivityMainBinding
import com.example.wongnaiassignmentapplication.model.CoinModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        initEventListener()
    }

    override fun initViewModel() {
        viewModel.coinList.observe(this, Observer {
            initAdapter(it)
            binding.swipe.isRefreshing = false

        })

    }

    override fun initEventListener() {
        binding.swipe.setOnRefreshListener {
            viewModel.callGetCoins()
        }
    }

    private fun initAdapter(list: PagedList<CoinModel>) {
        val coinAdapter =
            CoinAdapter()
        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = coinAdapter
        }
        coinAdapter.submitList(list)
    }

}