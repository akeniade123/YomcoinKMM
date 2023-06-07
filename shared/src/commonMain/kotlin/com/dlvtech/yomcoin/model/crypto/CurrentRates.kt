package com.dlvtech.yomcoin.model.crypto

data class CurrentRates(
    val asset_id_base: String,
    val rates: List<Rate>
)