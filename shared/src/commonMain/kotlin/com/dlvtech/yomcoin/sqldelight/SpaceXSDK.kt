package com.dlvtech.yomcoin.sqldelight

import com.dlvtech.yomcoin.sqldelight.cache.Database
import com.dlvtech.yomcoin.sqldelight.cache.DatabaseDriverFactory
import com.dlvtech.yomcoin.sqldelight.entity.RocketLaunch
import com.dlvtech.yomcoin.sqldelight.network.SpaceXApi



class SpaceXSDK (databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)
    private val api = SpaceXApi()

    @Throws(Exception::class) suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        val cachedLaunches = database.getAllLaunches()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
            api.getAllLaunches().also {
                database.clearDatabase()
                database.createLaunches(it)
            }
        }
    }
}
