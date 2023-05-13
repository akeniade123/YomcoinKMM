package com.dlvtech.yomcoin

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform