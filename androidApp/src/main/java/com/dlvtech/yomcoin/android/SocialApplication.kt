package com.dlvtech.yomcoin.android

import android.app.Application
import com.dlvtech.yomcoin.android.di.appModule
import com.dlvtech.yomcoin.di.getSharedModules
import org.koin.core.context.startKoin

class  SocialApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())

        }
    }
}