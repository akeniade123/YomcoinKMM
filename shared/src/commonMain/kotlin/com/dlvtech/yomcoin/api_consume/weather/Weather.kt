package com.dlvtech.yomcoin.api_consume.weather

import kotlinx.serialization.Serializable

@Serializable
data class Weather(val coord: Coordinate, val base: String)