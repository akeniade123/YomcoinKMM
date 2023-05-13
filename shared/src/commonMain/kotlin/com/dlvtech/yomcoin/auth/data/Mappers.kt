package com.dlvtech.yomcoin.auth.data

import com.dlvtech.yomcoin.auth.domain.model.AuthResultData

internal fun AuthResponseData.toAuthResultData(): AuthResultData{
    return AuthResultData(id, name, bio, avatar, token, followersCount, followingCount)
}