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
    val sects = remember{ DataProvider.stackList}

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
                LazyColumn(contentPadding =
                PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                )
                {

                    /*
                    items(
                        items = sects,
                        itemContent = {
                            Stack
                        }
                    )

                     */



                    //DashBoardListItem(dashBoardSect)
                }
                SectContent(modifier,basic)
                //DashBoardListItem()

                /*
                Text(text = "NotRegistered? ", style = MaterialTheme.typography.caption)
                Text(
                    text = "SignUp",
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.primary)

                 */
            }
        }
    }

    /*
    Scaffold{
    }
     */

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