package com.example.wongnaiassignmentapplication.di

import com.example.wongnaiassignmentapplication.module.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(
            get()
        )
    }
}