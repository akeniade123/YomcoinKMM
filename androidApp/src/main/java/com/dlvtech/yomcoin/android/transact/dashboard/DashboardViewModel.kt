package com.dlvtech.yomcoin.android.transact.dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class DashboardViewModel: ViewModel() {

    var uiState by mutableStateOf(DashBoardUiState())
        private set
}

data class DashBoardUiState(
    val id: Int = 0
)


data class DashBoardSect(
    val id: Int,
    val title: String,
    val description: String,
    val sectImageId: Int = 0
)

