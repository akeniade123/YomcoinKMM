package com.dlvtech.yomcoin.model.giftcard.giftcardTerrain

import kotlinx.serialization.Serializable


@Serializable
data class RedeemInstruction(
    val concise: String,
    val verbose: String
)