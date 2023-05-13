package com.dlvtech.yomcoin.android.auth.login

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import com.dlvtech.yomcoin.android.destinations.HomeScreenDestination
import com.dlvtech.yomcoin.android.destinations.SignUpDestination
import com.dlvtech.yomcoin.api_consume.weather.WeatherApi
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.ktor.client.engine.okhttp.*
//import io.ktor.client.engine.okhttp.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext
import org.koin.androidx.compose.koinViewModel
import kotlinx.coroutines.*


@Destination
@Composable
fun Login(
    navigator: DestinationsNavigator
) {
    val viewModel: LoginViewModel = koinViewModel()
    LoginScreen(
        uiState = viewModel.uiState,
        onEmailChange = viewModel::updateEmail,
        onPasswordChange = viewModel::updatePassword,
        onSignInClick = {
                        Log.i("Logger", "Info")

                        logger()


            /*
            val  job = Job()
            val coroutineContext: CoroutineContext
            get() = job
             */

            /*
            launch(Dispatchers.Main) {
                try {
                    val result = withContext(Dispatchers.IO) { weatherApi.fetchWeather() }
                    Toast.makeText(this@MainActivity, result.toString(), Toast.LENGTH_LONG).show()
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
                }
            }
             */



        },// viewModel::signIn,

        onNavigateToHome = {

            navigator.navigate(HomeScreenDestination){
                popUpTo(0)
            }
        },
        onNavigateToSignUp = {
            // Log.e("Checks", "Logger")

            navigator.navigate(SignUpDestination){
                popUpTo(0)
            }
        }
    )
}




fun logger() = runBlocking<Unit> {

    /*
    launch { // context of the parent, main runBlocking coroutine
        val weatherApi = WeatherApi(OkHttpEngine(OkHttpConfig()))

        val result = weatherApi.fetchWeather();
        println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
    }

     */

    launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
        println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")

        val weatherApi = WeatherApi(OkHttpEngine(OkHttpConfig()))
        val result = withContext(Dispatchers.IO) { weatherApi.fetchWeather() }
        //    Toast.makeText(this@MainActivity, result.toString(), Toast.LENGTH_LONG).show()

        Log.e("Login Thread", result.toString())

    }
    launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
        println("Default               : I'm working in thread ${Thread.currentThread().name}")
    }
    launch(newSingleThreadContext("MyOwnThread")) { // will get its own new thread
        println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
        try {
            val weatherApi = WeatherApi(OkHttpEngine(OkHttpConfig()))
            val result = withContext(Dispatchers.IO) { weatherApi.fetchWeather() }
            //    Toast.makeText(this@MainActivity, result.toString(), Toast.LENGTH_LONG).show()

            Log.e("Login Thread", result.toString())

            /*
            val result = withContext(Dispatchers.IO) { weatherApi.fetchWeather() }
            Toast.makeText(this@MainActivity, result.toString(), Toast.LENGTH_LONG).show()
            */

        } catch (e: Exception) {
            //   e.printStackTrace()
            Log.e("Login Thread Error", e.toString())
            //  Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
        }
    }


    launch(Dispatchers.Main) {

    }


}