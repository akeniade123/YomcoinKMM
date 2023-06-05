package com.dlvtech.yomcoin.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dlvtech.yomcoin.casts.Pane
import com.dlvtech.yomcoin.casts.Tabbed
import com.dlvtech.yomcoin.defs.add_fund
import com.dlvtech.yomcoin.defs.transfer
import com.dlvtech.yomcoin.defs.withdraw
import kotlinx.coroutines.launch
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


    val scaffoldState = rememberScaffoldState()



    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = { /* drawer content */ },
        drawerGesturesEnabled = true,
        backgroundColor = Color.White,
        topBar = {
            ToggleDrawerButton(scaffoldState.drawerState)
            TopAppBar(
                backgroundColor = Color.White,
                contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp),
                elevation = 0.dp
            ) {

                IconButton(modifier = Modifier
                    .clip(shape = RoundedCornerShape(25))
                    .background(BaseColor),
                    onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "menu",
                        tint = Color.White
                    )
                }

                Spacer(Modifier.weight(1f))

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Icon",
                        tint = BaseColor,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        }
    ) {



    }


    /*

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
    
     */

}



@Composable
fun ToggleDrawerButton(drawerState: DrawerState) {
    val coroutineScope = rememberCoroutineScope()
    Button(
        onClick = {
            coroutineScope.launch {
                if (drawerState.isOpen) {
                    drawerState.open()
                } else {
                    drawerState.close()
                }
            }
        }
    ) {
        Text("DRAWER")
    }
}







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