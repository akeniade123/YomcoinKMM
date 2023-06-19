package com.dlvtech.yomcoin.utils

/**
 * Multi platform implementation of a User preference / defaults reader
 * to store and read simple objects in user's settings.
 *
 * iOS: iOSMain/utils/
 * Android: androidMain/utils/
 */
actual class UserPreferenceReader actual constructor() {
    /**
     * Reads string for given key.
     * If key not found, it returns null
     *
     * @param key Key / Id of the value that shall be read.
     * @return Found string or nil
     */
    actual fun readString(key: String): String? {
        TODO("Not yet implemented")
    }

    /**
     * Stores given string for provided key.
     *
     * @param key Key / Id of the value that shall be stored.
     * @param value The value that shall be stored.
     */
    actual fun storeString(key: String, value: String?) {
    }

}