package com.dlvtech.yomcoin.android

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dlvtech.yomcoin.android.auth.login.LoginScreen
import com.dlvtech.yomcoin.android.auth.login.LoginViewModel
import com.dlvtech.yomcoin.android.auth.signup.SignUpScreen
import com.dlvtech.yomcoin.android.auth.signup.SignUpViewModel
import com.dlvtech.yomcoin.android.transact.dashboard.DashboardScreen
import com.dlvtech.yomcoin.android.transact.dashboard.DashboardViewModel
//import com.dlvtech.yomcoin.android.auth.Na
import com.ramcosta.composedestinations.DestinationsNavHost
import org.koin.androidx.compose.koinViewModel

@Composable
fun SocialApp() {

    /*
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "signup")
    {
        composable(route = "login")
        {
            val context = LocalContext.current
            val viewModel: LoginViewModel = koinViewModel()

            LoginScreen(
                uiState = viewModel.uiState,
                onEmailChange = viewModel::updateEmail,
                onPasswordChange = viewModel::updatePassword,
                onNavigateToHome = { /*TODO*/ },
                onSignInClick = { /*TODO*/ },
                onNavigateToSignUp = { /*TODO*/ }) {
            }
        }
        
        composable(route = "signup"){
            val context = LocalContext.current
            val viewModel: SignUpViewModel = koinViewModel()
            
            SignUpScreen(
                uiState = viewModel.uiState,
                onUsernameChange = viewModel::updateUsername,
                onEmailChange = viewModel::updateEmail ,
                onPasswordChange = viewModel::updatePassword,
                onNavigateToLogin = { /*TODO*/ },
                onNavigateToHome = { /*TODO*/ }) {
            }
        }
        
        composable(route = "dashboard")
        {
            val context = LocalContext.current
            val viewModel: DashboardViewModel = koinViewModel()
            
            DashboardScreen(uiState = viewModel.uiState)
        }

        
    }

     */

    val navHostController = rememberNavController()
    DestinationsNavHost(navGraph = NavGraphs.root, navController = navHostController)

}