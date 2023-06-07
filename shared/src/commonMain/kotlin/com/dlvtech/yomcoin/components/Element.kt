package com.dlvtech.yomcoin.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dlvtech.yomcoin.common.BaseColor


@Composable
fun TabStack(name:String, pntr: Painter)
{
    val imageModifier = Modifier
        .size(30.dp)

    Column(modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = pntr,
            modifier = imageModifier,
            contentDescription = "A poster image of a tennis player"
        )

        Text(
            text = name,
            color = Color.White,
            fontSize = 8.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )
    }
}



@Composable
fun Quote(quote:String, rate:Double)
{
    val imageModifier = Modifier
        .size(30.dp)

    Column(modifier = Modifier
        .clip(shape = RoundedCornerShape(10.dp))
        .clickable {  },
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = quote,
            color = Color.Black,
            fontSize = 15.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        Text(
            text = rate.toString(),
            color = BaseColor,
            fontSize = 15.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )

    }
}


/*

@Composable
expect fun AddTimeDialogWrapper(onDismiss: onDismissType, content: @Composable () -> Unit)


 */

