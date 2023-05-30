package com.dlvtech.yomcoin.android.prelim

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel


@Destination(start = true)
@Composable
fun Prelim(
    navigator: DestinationsNavigator
)
{
    val context = LocalContext.current
    val viewModel: PrelimViewModel = koinViewModel()

    PrelimScreen(
        uiState = viewModel.uiState)


}