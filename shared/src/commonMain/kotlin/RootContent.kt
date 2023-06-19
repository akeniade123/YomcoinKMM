package io.github.tscholze.cmpsample

import androidx.compose.runtime.*
import com.copperleaf.ballast.navigation.routing.Backstack
import com.copperleaf.ballast.navigation.routing.renderCurrentDestination
import com.copperleaf.ballast.navigation.vm.Router
import com.dlvtech.yomcoin.navigation.AppScreens
import com.dlvtech.yomcoin.navigation.RouterViewModel


import com.dlvtech.yomcoin.composables.screens.LocalResourceScreen
import com.dlvtech.yomcoin.composables.screens.OtherFeaturesScreen
import com.dlvtech.yomcoin.composables.screens.RemoteResourceScreen


/**
 * Entry point of the app.
 */
@Composable
internal fun RootContent() {

    // MARK: - Properties -

    val applicationScope = rememberCoroutineScope()
    val router: Router<AppScreens> = remember(applicationScope) { RouterViewModel(applicationScope) }
    val routerState: Backstack<AppScreens> by router.observeStates().collectAsState()

    // MARK: - Router -
    routerState.renderCurrentDestination(
        route = { appScreen: AppScreens ->
            when(appScreen) {
                AppScreens.LocalData -> LocalResourceScreen(router)
                AppScreens.RemoteData -> RemoteResourceScreen(router)
                AppScreens.OtherFeatures -> OtherFeaturesScreen(router)
            }
        },
        notFound = { },
    )
}

