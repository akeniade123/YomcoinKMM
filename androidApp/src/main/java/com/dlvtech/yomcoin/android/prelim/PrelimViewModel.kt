package com.dlvtech.yomcoin.android.prelim

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dlvtech.yomcoin.api_consume.ServerUtils
import com.dlvtech.yomcoin.common.util.routes
import com.dlvtech.yomcoin.defs.Appbase
import com.dlvtech.yomcoin.defs.user
import com.dlvtech.yomcoin.defs.users
import com.dlvtech.yomcoin.model.users.Users
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PrelimViewModel: ViewModel() {

    var uiState by mutableStateOf(PrelimUiState())
        private set

    val scope = MainScope()

    fun StackUsers() {
        var usrs: Users? = null
        scope.launch{
            kotlin.runCatching {
                val userStack = ServerUtils()
                val route: String = routes().eliteApi(user)

                usrs = withContext(Dispatchers.IO){ userStack.getContent(
                    route,
                    users,
                    Appbase
                )} as Users
            }.onSuccess {

            }
        }
    }

}


data class PrelimUiState(
    val users: Users? = null
)