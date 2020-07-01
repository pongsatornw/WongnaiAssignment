package com.example.wongnaiassignmentapplication.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

object ApiCallHandler {

    suspend inline fun<T> safeApiCall(
        crossinline request: suspend ()-> Unit
    ): Any {
       return try {
        request()


       } catch(ex: Exception) {
           withContext(Dispatchers.IO) {
               return@withContext when(ex) {
                   is UnknownHostException     -> ""
                   else                        -> ""
               }
           }

       }
    }

}