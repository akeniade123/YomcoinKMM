package com.dlvtech.yomcoin.android.theme.theme1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class Theme1ViewModel (): ViewModel(){
   // var uiState by mutableStateOf(ThemeUiState())

}



data class ThemeUiState(
    var name: String = ""
)