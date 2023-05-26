package com.dlvtech.yomcoin.model.users

import com.dlvtech.yomcoin.auth.data.eliteapi.userData.Data
import kotlinx.serialization.Serializable


@Serializable
data class Users(
    val `data`: List<Data>,
    val message: String,
    val status: Boolean
)