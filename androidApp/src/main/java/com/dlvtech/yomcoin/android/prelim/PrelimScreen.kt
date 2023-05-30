package com.dlvtech.yomcoin.android.prelim

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dlvtech.yomcoin.android.common.theming.SocialAppTheme
import com.dlvtech.yomcoin.android.model.casts.Pane
import com.dlvtech.yomcoin.android.model.casts.Tabbed
import com.dlvtech.yomcoin.android.theme.theme1.Club
import com.dlvtech.yomcoin.android.transact.dashboard.SectContent
import com.dlvtech.yomcoin.data.datacast.DataProvider
import com.dlvtech.yomcoin.defs.basic
import com.dlvtech.yomcoin.defs.transfer
import androidx.compose.ui.Modifier as Modifier1


val BaseColor:Color = Color(169,16,164)


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
            Color.Black,
            listOf(
                Tabbed(
                    "",
                    painterResource(id = com.dlvtech.yomcoin.android.R.drawable.tennis_player)
                )
            )
        ),
        Pane(
            "Crypto",
            "",
            BaseColor,
            listOf(
                Tabbed(
                    "",
                    painterResource(id = com.dlvtech.yomcoin.android.R.drawable.tennis_player))))
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
        }
    ) {
        Column(
            modifier = Modifier1
                .fillMaxSize()
                .verticalScroll(rememberScrollState(), true)
                .padding(start = 24.dp)
        ) {

            Text(
                text = stringResource(id = com.dlvtech.yomcoin.android.R.string.wallet),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h5.fontSize,
                modifier = Modifier1.padding(bottom = 20.dp)
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

            Spacer(modifier = Modifier1.size(30.dp))

            Row(
                modifier = Modifier1
                    .fillMaxWidth()
                    .padding(end = 16.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Train",
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Alles",
                    color = colorResource(id = com.dlvtech.yomcoin.android.R.color.green),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Column {
                for (i in 1..2) {
                    TrainItem()
                }
            }
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
            Column(Modifier1.width(300.dp)) {
                Image(
                    painter = pntr,
                    contentDescription = "Visibility",
                    contentScale = ContentScale.FillBounds
                )
                Spacer(
                    modifier = Modifier1.height(70.dp)
                )

                Row(
                    modifier = Modifier1
                        .padding(start = 10.dp)
                        .padding(top = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    LazyRow(modifier = Modifier1.fillMaxWidth())
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
    Column(modifier = Modifier1,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = name,
            color = Color.Black,
            fontSize = MaterialTheme.typography.h6.fontSize,
            modifier = Modifier1.padding(bottom = 10.dp)
        )

        Image(
            painter = pntr,
            contentDescription = "A poster image of a tennis player",
            contentScale = ContentScale.FillBounds
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


data class Club(
    var title: String,
    var color: Color,
    var image: Painter
)