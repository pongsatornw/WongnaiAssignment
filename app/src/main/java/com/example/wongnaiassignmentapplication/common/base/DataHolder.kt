package com.example.wongnaiassignmentapplication.common.base

import com.example.wongnaiassignmentapplication.api.APIResponseType
import com.example.wongnaiassignmentapplication.api.*
import com.example.wongnaiassignmentapplication.model.base.BaseResult

data class DataHolder<out T>(
    val isSuccess: APIResponseType,
    val data: T? = null
) {

    companion object {

        inline fun<reified T> success(data: BaseResult<T>): DataHolder<T> {
            return with(data) {
                if(this.status == "success") {
                    DataHolder<T>(isSuccess =  ApiSuccess(), data = data.data)
                } else {
                    DataHolder<T>(isSuccess = ApiError(), data = data.data)
                }
            }
        }

        inline fun<reified T> error(): DataHolder<T> {
            return DataHolder<T>(isSuccess = HttpError())
        }

    }

}