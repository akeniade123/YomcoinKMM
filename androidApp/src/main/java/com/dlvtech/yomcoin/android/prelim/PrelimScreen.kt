package com.dlvtech.yomcoin.android.prelim

import android.annotation.SuppressLint

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dlvtech.yomcoin.android.common.theming.SocialAppTheme
import com.dlvtech.yomcoin.casts.BottomNavItem
import com.dlvtech.yomcoin.casts.Pane
import com.dlvtech.yomcoin.casts.Tabbed
import com.dlvtech.yomcoin.android.theme.theme1.Club
import com.dlvtech.yomcoin.android.transact.dashboard.SectContent
import com.dlvtech.yomcoin.data.datacast.DataProvider
import com.dlvtech.yomcoin.defs.add_fund
import com.dlvtech.yomcoin.defs.basic
import com.dlvtech.yomcoin.defs.transfer
import com.dlvtech.yomcoin.defs.withdraw
import androidx.compose.ui.Modifier as Modifier1



val BaseColor: Color = Color(169,16,164)
val AccentColor:Color   = Color(228,79,223)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PrelimScreen(
    modifier: Modifier1 = Modifier1,
    uiState: PrelimUiState
)
{
   // val context = LocalContext.current

    val sects = remember {
        DataProvider.stackList
    }


    val panes = listOf(
        Pane(
            "Main Account",
            "",
            AccentColor,
            listOf(
                Tabbed(
                    add_fund,
                    painterResource(id = com.dlvtech.yomcoin.android.R.drawable.add_fund)
                ),
                Tabbed(
                    transfer,
                    painterResource(id = com.dlvtech.yomcoin.android.R.drawable.transfer)
                ),
                Tabbed(
                    withdraw,
                    painterResource(id = com.dlvtech.yomcoin.android.R.drawable.withdraw_cash)
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
                    painterResource(id = com.dlvtech.yomcoin.android.R.drawable.withdraw_cash)
                )
            )
        )
    )

    val clubs = listOf(
        Club(
            "Women's Club",
            colorResource(id = com.dlvtech.yomcoin.android.R.color.women),
            painterResource(id = com.dlvtech.yomcoin.android.R.drawable.tennis_player)
        ),
        Club(
            "Men's Club",
            colorResource(id = com.dlvtech.yomcoin.android.R.color.men),
            painterResource(id = com.dlvtech.yomcoin.android.R.drawable.men_tennis_player)
        )
    )



    val bottomNavItems = listOf(
        BottomNavItem(
            name = "Home",
            route = "home",
            icon = Icons.Rounded.Home,
        ),
        BottomNavItem(
            name = "Create",
            route = "add",
            icon = Icons.Rounded.AddCircle,
        ),
        BottomNavItem(
            name = "Settings",
            route = "settings",
            icon = Icons.Rounded.Settings,
        ),
    )

  //  val backStackEntry = navController.currentBackStackEntryAsState()


    val pnn: Pane = Pane(
        "Main Account",
        "Default transactions",
        BaseColor,
        listOf(
            Tabbed("",
                painterResource(id = com.dlvtech.yomcoin.android.R.drawable.add_fund)
            ),
            Tabbed("",
                painterResource(id = com.dlvtech.yomcoin.android.R.drawable.transfer)
            ),
            Tabbed("",
                painterResource(id = com.dlvtech.yomcoin.android.R.drawable.withdraw_cash)
            )
        )
    )

    Scaffold(
        backgroundColor = Color.White,
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp),
                elevation = 0.dp
            ) {

                IconButton(modifier = Modifier1
                    .clip(shape = RoundedCornerShape(25))
                    .background(BaseColor),
                    onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "menu",
                        tint = Color.White
                    )
                }

                Spacer(Modifier1.weight(1f))

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Icon",
                        tint = BaseColor,
                        modifier = Modifier1.size(32.dp)
                    )
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = BaseColor,
                elevation = 0.dp
            ) {
                LazyRow(
                    modifier = Modifier1
                        .fillMaxWidth()
                        .padding(start = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(60.dp)
                )
                {
                    items(pnn.tabs){ tab->
                        TabStack(name = tab.name, pntr = tab.image)
                    }
                }
            }
        }
    ) {
        Column(
            modifier = Modifier1
                .fillMaxSize()
                .verticalScroll(rememberScrollState(), true)
                .padding(start = 24.dp)
        ) {
            Row(
                modifier = Modifier1
                    .fillMaxWidth()
                    .padding(end = 16.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val pntr:Painter = painterResource(id = com.dlvtech.yomcoin.android.R.drawable.profile_pix)
                val invc:Painter = painterResource(id = com.dlvtech.yomcoin.android.R.drawable.transactions)
                val qrsc:Painter = painterResource(id = com.dlvtech.yomcoin.android.R.drawable.qr_scan)
                val ccre:Painter = painterResource(id = com.dlvtech.yomcoin.android.R.drawable.c_care)

                val imageModifier = Modifier1
                    .size(45.dp)

                val imageModifier_1 = Modifier1
                    .size(25.dp)

                Row()
                {
                    Image(
                        painter = pntr,
                        contentDescription = "Visibility",
                        modifier = imageModifier,
                        contentScale = ContentScale.FillBounds
                    )

                  //  Spacer(modifier = Modifier1.size(7.dp))

                    Column(modifier = Modifier1
                        .padding(start = 2.dp)
                        .padding(top = 15.dp)) {
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
                    modifier = Modifier1,
                    horizontalArrangement = Arrangement.SpaceBetween

                ){
                    Image(
                        painter = invc,
                        contentDescription = "Visibility",
                        modifier = imageModifier_1,
                        contentScale = ContentScale.FillBounds
                    )

                    Spacer(modifier = Modifier1.size(30.dp))

                    Image(
                        painter = qrsc,
                        contentDescription = "Visibility",
                        modifier = imageModifier_1,
                        contentScale = ContentScale.FillBounds
                    )

                    Spacer(modifier = Modifier1.size(30.dp))

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
                modifier = Modifier1.padding(bottom = 10.dp)
            )

            LazyRow(
                modifier = Modifier1.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(panes){ pane ->
                    AccountPane(pane)
                }

                /*
                items(clubs) { club ->
                    ClubItem(club)
                }
                 */


            }

            Spacer(modifier = Modifier1.size(10.dp))

            /*
            Column {
                for (i in 1..2) {
                    TrainItem()
                }
            }

             */
        }
    }

    /*
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

                SectContent(modifier,basic, sects)
            }
        }
    }

     */



}


@Preview
@Composable
fun PrelimScreenPreview()
{
    SocialAppTheme {
        PrelimScreen(uiState = PrelimUiState())
    }
}


/*
data class Pane(
    var title: String,
    var desc:  String,
    var image: Painter
)
 */

/*
val sects = listOf(
    Pane(
        "Main Account",
        "Default transactions",
        BaseColor
    )
)

 */

@Preview
@Composable
fun AccountPane(
    acct: Pane = Pane(
        "Main Account",
        "Default transactions",
        BaseColor,
        listOf(Tabbed("",painterResource(id = com.dlvtech.yomcoin.android.R.drawable.tennis_player))))
)
{
    val pntr:Painter = painterResource(id = com.dlvtech.yomcoin.android.R.drawable.hide_eye_icon_filled)

    Box(
        modifier = Modifier1
            .clip(shape = RoundedCornerShape(10.dp))
            .background(acct.color),
        contentAlignment = Alignment.Center
    )
    {
        Row(
            modifier = Modifier1
                .padding(start = 10.dp)
                .padding(top = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier1.width(320.dp)) {
                Image(
                    painter = pntr,
                    contentDescription = "Visibility",
                    contentScale = ContentScale.FillBounds
                )
                Spacer(
                    modifier = Modifier1.height(40.dp)
                )

                Row(
                    modifier = Modifier1
                        .padding(start = 10.dp)
                        .padding(top = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    LazyRow(
                        modifier = Modifier1
                            .fillMaxWidth()
                            .padding(start = 12.dp),
                        horizontalArrangement = Arrangement.spacedBy(60.dp)
                    )
                    {
                        items(acct.tabs){ tab->
                            TabStack(name = tab.name, pntr = tab.image )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TabStack(name:String, pntr: Painter)
{
    val imageModifier = Modifier1
        .size(30.dp)

    Column(modifier = Modifier1,
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
            modifier = Modifier1.padding(bottom = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ClubItem(
    club: Club = Club(
        "Women's Club",
        colorResource(id = com.dlvtech.yomcoin.android.R.color.men),
        painterResource(id = com.dlvtech.yomcoin.android.R.drawable.men_tennis_player)
    )
) {
    Box(
        modifier = Modifier1
            .clip(shape = RoundedCornerShape(30.dp))
            .background(club.color),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier1
                .padding(start = 20.dp)
                .padding(top = 25.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier1.width(150.dp)) {
                Text(
                    modifier = Modifier1.padding(bottom = 10.dp),
                    text = club.title,
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold
                )

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = stringResource(id = com.dlvtech.yomcoin.android.R.string.all_levels),
                        color = colorResource(id = com.dlvtech.yomcoin.android.R.color.black)
                    )
                }

                Spacer(modifier = Modifier1.height(180.dp))

                Text(
                    text = stringResource(id = com.dlvtech.yomcoin.android.R.string.events),
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    modifier = Modifier1.padding(bottom = 50.dp)
                )
            }

            //Tennis Player Image
            Image(
                painter = club.image,
                contentDescription = "A poster image of a tennis player",
                contentScale = ContentScale.FillBounds
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TrainItem() {
    Row(
        modifier = Modifier1
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier1
                .clip(shape = RoundedCornerShape(10.dp))
                .background(colorResource(id = com.dlvtech.yomcoin.android.R.color.green_ball))
                .padding(5.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = com.dlvtech.yomcoin.android.R.drawable.tennis_balls),
                contentDescription = "Tennis Ball"
            )
        }

        Spacer(modifier = Modifier1.size(8.dp))

        Column {
            Text(
                text = "Yoga & Tennis",
                color = colorResource(id = com.dlvtech.yomcoin.android.R.color.black),
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Feb 27 | 10:00am-11:00am",
                color = Color.LightGray,
                fontSize = 16.sp,
                modifier = Modifier1.padding(top = 5.dp),
            )
        }

        Spacer(modifier = Modifier1.weight(1f))

        Box(
            modifier = Modifier1
                .clip(shape = CircleShape)
                .background(colorResource(id = com.dlvtech.yomcoin.android.R.color.black)),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "$10",
                color = colorResource(id = com.dlvtech.yomcoin.android.R.color.white),
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier1.padding(7.dp),
            )
        }

    }
}
