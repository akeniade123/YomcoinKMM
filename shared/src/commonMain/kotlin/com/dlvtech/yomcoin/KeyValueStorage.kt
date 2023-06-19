package com.dlvtech.yomcoin

import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.Serializable

interface KeyValueStorage {

    // #1 - Primitive type
    var token: String?

    // #2 - Custom type
    var loginInfo: LoginInfo?

    // #3 - Observer token value changes
    val observableToken: Flow<String>

    fun cleanStorage()
}

@Serializable
data class LoginInfo(val username: String, val password: Int)


enum class StorageKeys {
    TOKEN,
    LOGIN_INFO;

    val key get() = this.name
}