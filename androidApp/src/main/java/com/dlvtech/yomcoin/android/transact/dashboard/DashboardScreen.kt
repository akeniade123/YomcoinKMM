package com.dlvtech.yomcoin.android.transact.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.dlvtech.yomcoin.data.datacast.DataProvider
import com.dlvtech.yomcoin.defs.basic
import com.dlvtech.yomcoin.model.users.Users
import kotlin.reflect.KFunction1

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    uiState: DashBoardUiState,
    usrs: KFunction1<Users, Unit>
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





/*

@Preview
@Composable
fun DashBoardScreenPreview()
{
    SocialAppTheme {
        DashboardScreen(
            uiState = DashBoardUiState(),
            usrs = Users(List<Data>)
        )
    }
}

 */