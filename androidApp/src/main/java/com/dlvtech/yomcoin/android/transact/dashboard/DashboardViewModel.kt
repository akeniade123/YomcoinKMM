package com.dlvtech.yomcoin.android.transact.dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dlvtech.yomcoin.model.users.Users

class DashboardViewModel: ViewModel() {

    var uiState by mutableStateOf(DashBoardUiState())
        private set


    fun updateUsers(users: Users){
        uiState = uiState.copy(usrs = users)
    }
}

data class DashBoardUiState(
    val usrs: Users? = null
)


data class DashBoardSect(
    val id: Int,
    val title: String,
    val description: String,
    val sectImageId: Int = 0
)




