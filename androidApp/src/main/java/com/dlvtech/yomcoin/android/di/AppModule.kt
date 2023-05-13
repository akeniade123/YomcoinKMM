package com.dlvtech.yomcoin.android.di

import com.dlvtech.yomcoin.android.auth.login.LoginViewModel
import com.dlvtech.yomcoin.android.auth.signup.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { SignUpViewModel(get()) }
}