package com.dlvtech.yomcoin.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

@Composable
actual fun imageResources(image: String): Painter {
    val context = LocalContext.current
    val name = image.substringBefore(".")
    val drawable = context.resources.getIdentifier(name, "drawable", context.packageName)
    return painterResource(drawable)
}