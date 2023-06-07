package com.dlvtech.yomcoin.model.crypto


import kotlinx.serialization.Serializable


@Serializable
data class CurrentRates(
    val asset_id_base: String,
    val rates: List<Rate>
)