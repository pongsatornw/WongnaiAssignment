package com.example.wongnaiassignmentapplication.common.base

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

@Suppress("Registered")
class BaseActivity<T: ViewBinding>: AppCompatActivity() {

    open val viewModel: ViewModel
        get() = BaseViewModel()

}