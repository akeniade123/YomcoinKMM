package com.dlvtech.yomcoin.android.transact.dashboard


import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel


@Destination
@Composable
fun DashBoard(
    navigator: DestinationsNavigator
){
    val context = LocalContext.current
    val viewModel: DashboardViewModel = koinViewModel()
    DashboardScreen(
        uiState = viewModel.uiState
    )
}