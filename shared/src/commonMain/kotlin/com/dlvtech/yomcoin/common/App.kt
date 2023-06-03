package com.dlvtech.yomcoin.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dlvtech.yomcoin.casts.Pane
import com.dlvtech.yomcoin.casts.Tabbed
import com.dlvtech.yomcoin.defs.add_fund
import com.dlvtech.yomcoin.defs.transfer
import com.dlvtech.yomcoin.defs.withdraw
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


val BaseColor: Color = Color(169,16,164)
val AccentColor: Color = Color(228,79,223)



@OptIn(ExperimentalResourceApi::class)
@Composable
fun App()
{
    var count by remember {
        mutableStateOf(0)
    }
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = {
                count++
            }
        )
        {
            Text( "Count: $count")
        }
    }

}