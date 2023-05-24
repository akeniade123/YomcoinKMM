package com.dlvtech.yomcoin.model.giftcard.giftcardTerrain

import kotlinx.serialization.Serializable


@Serializable
data class Brand(
    val brandId: Int,
    val brandName: String
)