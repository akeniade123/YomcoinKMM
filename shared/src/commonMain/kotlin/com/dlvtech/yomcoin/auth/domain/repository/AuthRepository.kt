package com.dlvtech.yomcoin.auth.domain.repository

import com.dlvtech.yomcoin.auth.domain.model.AuthResultData
import com.dlvtech.yomcoin.common.util.Result

internal interface AuthRepository {

    suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): Result<AuthResultData>

    suspend fun signIn(email: String, password: String): Result<AuthResultData>
}