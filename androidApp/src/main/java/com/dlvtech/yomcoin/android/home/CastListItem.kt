package com.dlvtech.yomcoin.data.datacast.com.dlvtech.yomcoin.android.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.dlvtech.yomcoin.model.Sect

class CastListItem {


    @Composable
    fun castListItem(sect: Sect) {
        Row {
            Column {
                Text(text = sect.title, style = typography.h6)
                Text(text = "VIEW DETAIL", style = typography.caption)
            }
        }
    }


}