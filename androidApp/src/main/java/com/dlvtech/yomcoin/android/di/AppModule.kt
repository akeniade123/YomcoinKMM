package com.dlvtech.yomcoin.android.di

import com.dlvtech.yomcoin.android.auth.login.LoginViewModel
import com.dlvtech.yomcoin.android.auth.signup.SignUpViewModel
import com.dlvtech.yomcoin.android.prelim.PrelimViewModel
import com.dlvtech.yomcoin.android.theme.theme1.Theme1ViewModel
import com.dlvtech.yomcoin.android.transact.dashboard.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { SignUpViewModel(get()) }
    viewModel { DashboardViewModel() }
    viewModel { PrelimViewModel() }
}