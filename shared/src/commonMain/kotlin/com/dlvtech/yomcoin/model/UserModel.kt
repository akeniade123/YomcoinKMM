package com.dlvtech.yomcoin.model

import kotlinx.serialization.Serializable

@Serializable
data class UserModel(
    val name: String?,
    val email: String?
)