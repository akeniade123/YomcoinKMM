package com.dlvtech.yomcoin.android.transact.dashboard

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dlvtech.yomcoin.data.datacast.DataProvider
import com.dlvtech.yomcoin.defs.basic

@Composable
fun SectContent(
    modifier: Modifier = Modifier,
    phase: String
) {

    val sects = remember {
        DataProvider.stackList
    }

    when(phase)
    {
        basic -> {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(
                    items = sects,
                    itemContent = {
                        SectListItem(sect = it)
                    })
            }

            /*
            Row {
                Column {
                    // Text(text = puppy.title, style = typography.h6)
                    Text(text = "VIEW DETAIL", style = MaterialTheme.typography.caption)
                }
            }

             */
        }
    }

}