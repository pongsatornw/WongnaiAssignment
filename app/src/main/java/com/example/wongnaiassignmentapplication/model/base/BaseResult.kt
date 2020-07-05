package com.example.wongnaiassignmentapplication.model.base

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class BaseResult<out T>(
    @field:Json(name = "status") val status: String = "",
    @field:Json(name = "data") val data: T? = null
) {

    companion object {

        inline fun<reified T> success(status: String, data: T): BaseResult<T> {
            return BaseResult<T>(status = status, data = data)
        }

        inline fun<reified T> error(status: String): BaseResult<T> {
            return BaseResult<T>(status = status, data = null)
        }

    }

}