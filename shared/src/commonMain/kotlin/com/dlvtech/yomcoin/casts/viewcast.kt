package com.dlvtech.yomcoin.casts

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class Pane(
    var title: String,
    var desc:  String,
    var color: Color,
    var tabs: List<Tabbed>
)

data class Tabbed(
    var name: String,
    var image: Painter
)


data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
)

