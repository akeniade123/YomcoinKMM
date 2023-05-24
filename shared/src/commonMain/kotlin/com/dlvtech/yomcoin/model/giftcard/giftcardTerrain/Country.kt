package com.dlvtech.yomcoin.model.giftcard.giftcardTerrain

import kotlinx.serialization.Serializable


@Serializable
data class Country(
    val flagUrl: String,
    val isoName: String,
    val name: String
)