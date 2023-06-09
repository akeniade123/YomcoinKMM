package com.dlvtech.yomcoin.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dlvtech.yomcoin.common.BaseColor
import com.dlvtech.yomcoin.common.ControlColor
import com.dlvtech.yomcoin.common.imageResources
import com.dlvtech.yomcoin.utils.TimeTravelViewModel


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
    val viewModel = TimeTravelViewModel()
    val composeColor = viewModel.composeColor
    val flowColor by viewModel.color.collectAsState()


    //  val pntr:Painter = imageResources("drawable/pane.9.png") // painterResource("drawable/profile_pix.png")
    Column(modifier = Modifier
        .fillMaxWidth()
       // .paint(pntr)
        .background(BaseColor)
        .clip(shape = RoundedCornerShape(20.dp))
        .padding(45.dp)

        .clickable {
           // viewModel.generateNewColor()
            println("Clicked on $quote")
        }
        //horizontalAlignment = Alignment.CenterHorizontally

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

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Spacer(Modifier.weight(1f))

            Text(
                text = "2023-06-07T13:17:45.0000000Z",
                color = BaseColor,
                fontSize = 7.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )


        }
    }
}


/*

@Composable
expect fun AddTimeDialogWrapper(onDismiss: onDismissType, content: @Composable () -> Unit)


 */

