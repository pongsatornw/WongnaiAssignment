package com.example.wongnaiassignmentapplication.api

import android.util.Log
import android.widget.Toast
import com.example.wongnaiassignmentapplication.model.base.BaseResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.experimental.property.inject
import java.net.UnknownHostException

object ApiCallHandler {

    suspend inline fun<T> safeApiCall(

        crossinline request: suspend () -> BaseResult<T>
    ): BaseResult<T> {
       return try {
           request()

       } catch(ex: Exception) {
           withContext(Dispatchers.IO) {
               return@withContext when(ex) {
                   is UnknownHostException     -> ""
                   else                        -> ""
               }
           }

           /**
            * HANDLE NETWORK ERROR.
            * */

           Log.e("CALL_ERROR", ex.message?:"")

           BaseResult<T>()

       }
    }

}