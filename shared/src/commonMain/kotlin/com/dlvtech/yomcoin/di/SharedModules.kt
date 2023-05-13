package com.dlvtech.yomcoin.di

import com.dlvtech.yomcoin.auth.data.AuthRepositoryImpl
import com.dlvtech.yomcoin.auth.data.AuthService
import com.dlvtech.yomcoin.auth.domain.repository.AuthRepository
import com.dlvtech.yomcoin.auth.domain.usecase.SignInUseCase
import com.dlvtech.yomcoin.auth.domain.usecase.SignUpUseCase
//import com.dlvtech.yomcoin.common.util.provideDispatcher
import org.koin.dsl.module

private val authModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
    factory { AuthService() }
    factory { SignUpUseCase() }
    factory { SignInUseCase() }
}

private val utilityModule = module {
   // factory { provideDispatcher() }
}

fun getSharedModules() = listOf(authModule, utilityModule)