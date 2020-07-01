package com.example.wongnaiassignmentapplication.model

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class CoinModel(
    @field:Json(name = "allTimeHigh") val allTimeHigh: AllTimeHigh,
    @field:Json(name = "approvedSupply") val approvedSupply: Boolean,
    @field:Json(name = "change") val change: Double,
    @field:Json(name = "circulatingSupply") val circulatingSupply: Int,
    @field:Json(name = "color") val color: String,
    @field:Json(name = "confirmedSupply") val confirmedSupply: Boolean,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "firstSeen") val firstSeen: Long,
    @field:Json(name = "history") val history: List<Any>,
    @field:Json(name = "iconType") val iconType: String,
    @field:Json(name = "iconUrl") val iconUrl: String,
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "links") val links: List<Link>,
    @field:Json(name = "marketCap") val marketCap: Long,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "numberOfExchanges") val numberOfExchanges: Int,
    @field:Json(name = "numberOfMarkets") val numberOfMarkets: Int,
    @field:Json(name = "penalty") val penalty: Boolean,
    @field:Json(name = "price") val price: String,
    @field:Json(name = "rank") val rank: Int,
    @field:Json(name = "slug") val slug: String,
    @field:Json(name = "socials") val socials: List<Social>,
    @field:Json(name = "symbol") val symbol: String,
    @field:Json(name = "totalSupply") val totalSupply: Int,
    @field:Json(name = "type") val type: String,
    @field:Json(name = "uuid") val uuid: String,
    @field:Json(name = "volume") val volume: Long,
    @field:Json(name = "websiteUrl") val websiteUrl: String
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