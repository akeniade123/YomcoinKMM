package com.dlvtech.yomcoin.model.giftcard.giftcardTerrain

import kotlinx.serialization.Serializable


@Serializable
data class Balance(
    val balance: Double,
    val currencyCode: String,
    val currencyName: String,
    val updatedAt: String
)