package com.example.wongnaiassignmentapplication.common.base

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

@Suppress("Registered")
abstract class BaseActivity<T: ViewBinding>: AppCompatActivity() {

    open val viewModel: ViewModel
        get() = BaseViewModel()

    open lateinit var binding: T

    abstract fun initViewModel()

    abstract fun initEventListener()

}