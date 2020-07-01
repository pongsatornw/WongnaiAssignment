package com.example.wongnaiassignmentapplication.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class BaseModel(
    @field:Json(name = "sign") val sign: String,
    @field:Json(name = "symbol") val symbol: String
)