package com.dlvtech.yomcoin.common

import ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class AppModelView:ViewModel() {

    var uiState by mutableStateOf(AppUiState())

}


data class AppUiState(
    var email: String = "",
    var password: String = ""
)