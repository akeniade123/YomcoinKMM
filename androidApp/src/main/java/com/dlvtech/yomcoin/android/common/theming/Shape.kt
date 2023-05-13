package com.dlvtech.yomcoin.android.common.theming

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import com.dlvtech.yomcoin.android.common.theming.LargeSpacing
import com.dlvtech.yomcoin.android.common.theming.MediumSpacing
import com.dlvtech.yomcoin.android.common.theming.SmallSpacing

val Shapes = Shapes(
    small = RoundedCornerShape(SmallSpacing),
    medium = RoundedCornerShape(MediumSpacing),
    large = RoundedCornerShape(LargeSpacing)
)