package com.example.wongnaiassignmentapplication.model.base

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class BaseResult<out T>(
    @field:Json(name = "status") private val _status: String = "",
    @field:Json(name = "data") private val _data: T? = null
) {

    fun getData(): T? = _data

}