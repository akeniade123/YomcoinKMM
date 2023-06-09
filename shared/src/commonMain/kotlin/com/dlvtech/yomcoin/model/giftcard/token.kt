package com.dlvtech.yomcoin.model.giftcard

import kotlinx.serialization.Serializable

@Serializable
data class token(
    val access_token: String,
    val expires_in: Int,
    val scope: String,
    val token_type: String
)