package com.dlvtech.yomcoin.model.crypto

import kotlinx.serialization.Serializable


@Serializable
data class Rate(
    val time: String,
    val asset_id_quote: String,
    val rate: Double,

)