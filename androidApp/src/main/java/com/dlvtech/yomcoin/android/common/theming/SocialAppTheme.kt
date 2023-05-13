package com.dlvtech.yomcoin.android.common.theming

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.dlvtech.yomcoin.android.common.theming.DarkColors
import com.dlvtech.yomcoin.android.common.theming.LightColors
import com.dlvtech.yomcoin.android.common.theming.Shapes

@Composable
fun SocialAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) DarkColors else LightColors
    MaterialTheme(
        colors = colors,
        shapes = Shapes,
        typography = Typography,
        content = content
    )
}
