package com.dlvtech.yomcoin.android.prelim

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dlvtech.yomcoin.android.common.theming.SocialAppTheme
import com.dlvtech.yomcoin.android.transact.dashboard.SectContent
import com.dlvtech.yomcoin.data.datacast.DataProvider
import com.dlvtech.yomcoin.defs.basic


@Composable
fun PrelimScreen(
    modifier: Modifier = Modifier,
    uiState: PrelimUiState
)
{
    val context = LocalContext.current

    val sects = remember {
        DataProvider.stackList
    }

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

            Column(modifier = Modifier
                .fillMaxWidth())
            {

                SectContent(modifier, basic, sects)
            }
        }
    }
}


@Preview
@Composable
fun PrelimScreenPreview()
{
    SocialAppTheme {
        PrelimScreen(uiState = PrelimUiState())
    }
}