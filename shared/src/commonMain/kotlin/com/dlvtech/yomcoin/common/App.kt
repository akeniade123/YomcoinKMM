package com.dlvtech.yomcoin.common

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dlvtech.yomcoin.api_consume.ServerUtils
import com.dlvtech.yomcoin.casts.Pane
import com.dlvtech.yomcoin.casts.Tabbed
import com.dlvtech.yomcoin.common.views.AccountPane
import com.dlvtech.yomcoin.components.Quote
import com.dlvtech.yomcoin.components.TabStack
import com.dlvtech.yomcoin.data.datacast.CryptoData
import com.dlvtech.yomcoin.defs.*
import com.dlvtech.yomcoin.utils.TimeTravelViewModel
import com.plcoding.navigationdrawercompose.DrawerBody
import com.plcoding.navigationdrawercompose.DrawerHeader
import com.plcoding.navigationdrawercompose.MenuItem
import kotlinx.coroutines.launch
//import com.dlvtech.yomcoin.ViewModel


import org.jetbrains.compose.resources.ExperimentalResourceApi


val BaseColor: Color = Color(169,16,164)
val AccentColor: Color = Color(228,79,223)
val ControlColor: Color = Color(0xF6EBEB)

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    var count by remember {
        mutableStateOf(0)
    }

    val scaffoldState = rememberScaffoldState()

    val scope = rememberCoroutineScope()

    val svr  = ServerUtils()


    val panes = listOf(
        Pane(
            "Main Account",
            "",
            AccentColor,
            listOf(
                Tabbed(
                    add_fund,
                    imageResources("drawable/add_fund.png")
                ),
                Tabbed(
                    transfer,
                    imageResources("drawable/transfer.png")
                ),
                Tabbed(
                    withdraw,
                    imageResources("drawable/withdraw_cash.png")
                )
            )
        ),
        Pane(
            "Crypto",
            "",
            BaseColor,
            listOf(
                Tabbed(
                    withdraw,
                    imageResources("drawable/withdraw_cash.png")
                )
            )
        )
    )

   // val Rates:rates = ("BTC",rate)

    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = Color.White,
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                contentPadding = PaddingValues(horizontal = 24.dp,
                    vertical = 16.dp),
                elevation = 0.dp
            ) {
                IconButton(modifier = Modifier
                    .clip(shape = RoundedCornerShape(25))
                    .background(BaseColor),
                    onClick = { scope.launch {
                        scaffoldState.drawerState.open()
                    } }) {
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
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            DrawerHeader()
            DrawerBody(
                items = listOf(
                    MenuItem(
                        id = "home",
                        title = "Home",
                        contentDescription = "Go to home screen",
                        icon = Icons.Default.Home
                    ),
                    MenuItem(
                        id = "settings",
                        title = "Settings",
                        contentDescription = "Go to settings screen",
                        icon = Icons.Default.Settings
                    ),
                    MenuItem(
                        id = "help",
                        title = "Help",
                        contentDescription = "Get help",
                        icon = Icons.Default.Info
                    ),
                ),
                onItemClick = {
                    when(it.id)
                    {
                        "help" ->{

                        }
                    }
                    println("Clicked on ${it.title}")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color.White,
                contentPadding = PaddingValues(horizontal = 24.dp)
            ) {

                val tabs: List<Tabbed> =listOf(
                    Tabbed("Home",
                        imageResources("drawable/home.png")
                ),
                    Tabbed("Utility Bills",
                        imageResources("drawable/utility_bill.png")
                    ),
                    Tabbed("GiftCard",
                        imageResources("drawable/giftcard.png")
                    )
                )
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                )
                {

                    items(tabs){ tab->
                        TabStack(
                            name = tab.name,
                            pntr = tab.image,
                            fontsize = 8.sp,
                            imagesize = 20.dp,
                            textColor = BaseColor
                        )
                    }
                }
            }
        }

    ) {

        val viewModel = TimeTravelViewModel()
        val composeColor = viewModel.composeColor
        val flowColor by viewModel.color.collectAsState()



        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState(), true)
                .padding(start = 24.dp)
                .background(Color(flowColor))
                .clickable {
                  //  viewModel.generateNewColor()
                }

        )
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val pntr:Painter = imageResources("drawable/profile_pix.png") // painterResource("drawable/profile_pix.png")
                val invc:Painter = imageResources("drawable/transactions.png") // painterResource("drawable/transactions.png")
                val qrsc:Painter = imageResources("drawable/qr_scan.png") // painterResource("drawable/qr_scan.png")
                val ccre:Painter = imageResources("drawable/c_care.png") // painterResource("drawable/c_care.png")


                val imageModifier = Modifier
                    .size(45.dp)

                val imageModifier_1 = Modifier
                    .size(25.dp)

                Row()
                {
                    Image(
                        painter = pntr,
                        contentDescription = "Visibility",
                        modifier = imageModifier,
                        contentScale = ContentScale.FillBounds
                    )


                    Column(modifier = Modifier
                        .padding(start = 2.dp)
                        .padding(top = 1.dp)) {
                        Text(
                            text = "Welcome",
                            color = Color.Black,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Italic
                        )

                        Text(
                            text = "Adeyinka",
                            color = Color.Black,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.SpaceBetween

                ){
                    Image(
                        painter = invc,
                        contentDescription = "Visibility",
                        modifier = imageModifier_1,
                        contentScale = ContentScale.FillBounds
                    )

                    Spacer(modifier = Modifier.size(30.dp))

                    Image(
                        painter = qrsc,
                        contentDescription = "Visibility",
                        modifier = imageModifier_1,
                        contentScale = ContentScale.FillBounds
                    )

                    Spacer(modifier = Modifier.size(30.dp))

                    Image(
                        painter = ccre,
                        contentDescription = "Visibility",
                        modifier = imageModifier_1,
                        contentScale = ContentScale.FillBounds
                    )
                }
            }

            Text(
                text = "Wallet",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(panes){ pane ->
                    AccountPane(pane)
                }
            }
            Spacer(modifier = Modifier.size(10.dp))

           // val viewModel = viewModel<TimeTravelViewModel>()

          //  val viewModel: TimeTravelViewModel =




            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Spacer(Modifier.weight(1f))

                val imageModifier = Modifier
                    .size(60.dp)
                    .padding(15.dp)

                val pntr:Painter = imageResources("drawable/bitcoin.png") // painterResource("drawable/profile_pix.png")


                Image(
                    painter = pntr,
                    contentDescription = "Visibility",
                    modifier = imageModifier,
                    contentScale = ContentScale.FillBounds
                )
            }







            /*
           // val vmdl  = ViewModel()
            //ViewModel().viewModelScope.launch {  }

            scope.launch {
                kotlin.runCatching {
                    val route: String = routes().cryptoApi(currentRate)
                    //   Log.d("APiPath", route)

                    val rst = withContext(Dispatchers.Default){
                        svr.getContent(
                            route,
                            currentRate,
                            CoinApi
                        )
                    } as CurrentRates

                    rate = rst.rates

                }.onSuccess {

                }
            }
           // viewModel.updateUsers(rst)

             */
        }

        val crypto = remember {
            CryptoData. cryptoList
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 300.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            items(crypto){ crp ->
                Quote(crp.asset_id_quote,crp.rate)
            }
        }
    }
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





//Icon(painter = org.jetbrains.compose.resources.painterResource("drawable/some_drawable.xml"))



