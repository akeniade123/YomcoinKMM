package com.dlvtech.yomcoin.model.crypto

data class Rate(
    val asset_id_quote: String,
    val rate: Double,
    val time: String
)