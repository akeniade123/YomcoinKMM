package com.dlvtech.yomcoin.api_consume.weather

import kotlinx.serialization.Serializable

@Serializable
data class Coordinate(val lon: Float, val lat: Float)