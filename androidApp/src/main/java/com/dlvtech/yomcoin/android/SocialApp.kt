package com.dlvtech.yomcoin.android

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
//import com.dlvtech.yomcoin.android.auth.Na
import com.ramcosta.composedestinations.DestinationsNavHost

@Composable
fun SocialApp() {
    val navHostController = rememberNavController()

    DestinationsNavHost(navGraph = NavGraphs.root, navController = navHostController)
}