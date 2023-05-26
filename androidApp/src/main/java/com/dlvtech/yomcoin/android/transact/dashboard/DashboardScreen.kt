package com.dlvtech.yomcoin.android.transact.dashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dlvtech.yomcoin.android.common.theming.SocialAppTheme
import com.dlvtech.yomcoin.data.datacast.DataProvider
import com.dlvtech.yomcoin.defs.basic

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    uiState: DashBoardUiState

)
{
    val context = LocalContext.current
    val dashBoardSect: DashBoardSect

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)){
        Column(modifier = Modifier
            .fillMaxWidth()
        ) {
            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .weight(1f))
            {
                //SectContent(phase = basic)
            }

            Row(modifier = Modifier
                .fillMaxWidth())
            {
                val sects = remember {
                    DataProvider.stackList
                }
                SectContent(modifier,basic, sects)
            }
        }
    }
}




@Preview
@Composable
fun DashBoardScreenPreview()
{
    SocialAppTheme {
        DashboardScreen(
            uiState = DashBoardUiState()
        )
    }
}