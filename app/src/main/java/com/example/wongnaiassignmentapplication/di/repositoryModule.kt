package com.example.wongnaiassignmentapplication.di

import com.example.wongnaiassignmentapplication.repository.CoinRepositoryImpl
import com.example.wongnaiassignmentapplication.repository.base.CoinRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<CoinRepository> { CoinRepositoryImpl(get()) }

}