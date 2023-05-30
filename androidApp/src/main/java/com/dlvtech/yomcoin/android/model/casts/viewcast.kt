package com.dlvtech.yomcoin.android.model.casts

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

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

