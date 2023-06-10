package com.dlvtech.yomcoin.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Sect(
    val id: Int,
    val title: String,
    val description: String,
    val sectImageId: Int = 0
)


data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
)