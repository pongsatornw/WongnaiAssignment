package com.example.wongnaiassignmentapplication.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class CoinModel(
    @field:Json(name = "description") val description: String,
    @field:Json(name = "firstSeen") val firstSeen: Long,
    @field:Json(name = "history") val history: List<Any>,
    @field:Json(name = "iconType") val iconType: String,
    @field:Json(name = "iconUrl") val iconUrl: String,
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "links") val links: List<Link>,
    @field:Json(name = "marketCap") val marketCap: Long,
    @field:Json(name = "name") val name: String
)

@Keep
data class AllTimeHigh(
    @field:Json(name = "price") val price: String,
    @field:Json(name = "timestamp") val timestamp: Long
)

@Keep
data class Link(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "type") val type: String,
    @field:Json(name = "url") val url: String
)

@Keep
data class Social(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "type") val type: String,
    @field:Json(name = "url") val url: String
)