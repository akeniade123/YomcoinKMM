package com.dlvtech.yomcoin.common.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.dlvtech.yomcoin.casts.Pane
import com.dlvtech.yomcoin.casts.Tabbed
import com.dlvtech.yomcoin.common.BaseColor
import com.dlvtech.yomcoin.common.imageResources
import com.dlvtech.yomcoin.components.TabStack


@Composable
fun AccountPane(
    acct: Pane = Pane(
        "Main Account",
        "Default transactions",
        BaseColor,
        listOf(Tabbed("",
            imageResources("drawable/transfer.png")
        )))
)
{
    val pntr: Painter = imageResources("drawable/transfer.png")

    val foil: Painter = imageResources("drawable/foil.png")

    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .background(acct.color),
        contentAlignment = Alignment.Center
    )
    {
        Row(
            modifier = Modifier
                .padding(start = 10.dp)
                .padding(top = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.width(320.dp)) {

                Row(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Image(
                        painter = pntr,
                        contentDescription = "Visibility",
                        contentScale = ContentScale.FillBounds
                    )

                    Spacer(Modifier.weight(1f))

                    Image(
                        modifier = Modifier
                            .padding(end = 20.dp)
                            .size(30.dp),
                        painter = foil,
                        contentDescription = "Visibility",
                        contentScale = ContentScale.FillBounds
                    )
                }




                Spacer(
                    modifier = Modifier.height(40.dp)
                )

                Row(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(top = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    LazyRow(
                        modifier = Modifier
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