package com.dlvtech.yomcoin.sqldelight.cache

import android.content.Context
import com.dlvtech.yomcoin.shared.cache.AppDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
       // TODO("Not yet implemented")
        return AndroidSqliteDriver(AppDatabase.Schema, context, "test.db")
    }
}