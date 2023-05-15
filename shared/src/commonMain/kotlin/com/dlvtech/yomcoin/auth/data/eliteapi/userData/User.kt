package com.dlvtech.yomcoin.auth.data.eliteapi.userData

import kotlinx.serialization.Serializable


@Serializable
data class User(
    val `data`: List<Data>,
    val message: String,
    val status: Boolean
)