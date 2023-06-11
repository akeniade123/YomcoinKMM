package com.dlvtech.yomcoin.composables.layouts

import androidx.compose.runtime.Composable
import com.copperleaf.ballast.navigation.vm.Router
import com.dlvtech.yomcoin.composables.components.CMPScaffold
import com.dlvtech.yomcoin.navigation.AppScreens
import com.dlvtech.yomcoin.theme.CMPTheme

/**
 * Themed-styled layout for a full screen styled page.
 */
@Composable
internal fun PageLayout(title: String, router: Router<AppScreens>, content: @Composable () -> Unit) {
    CMPTheme {
        CMPScaffold(title, router) {
            content()
        }
    }
}