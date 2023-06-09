package com.dlvtech.yomcoin.android.auth.signup

import androidx.compose.runtime.Composable
import com.dlvtech.yomcoin.android.destinations.HomeScreenDestination
import com.dlvtech.yomcoin.android.destinations.LoginDestination
//import com.dlvtech.yomcoin.android.destinations.LoginDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@Destination
@Composable
fun SignUp(
    navigator: DestinationsNavigator
) {
    val viewModel: SignUpViewModel = koinViewModel()
    SignUpScreen(
        uiState = viewModel.uiState,
        onUsernameChange = viewModel::updateUsername,
        onEmailChange = viewModel::updateEmail,
        onPasswordChange = viewModel::updatePassword,
        onNavigateToLogin = {
            navigator.navigate(LoginDestination)
        },
        onNavigateToHome = {
            navigator.navigate(HomeScreenDestination){
                popUpTo(0)
            }
        },
        onSignUpClick = viewModel::signUp
    )
}










