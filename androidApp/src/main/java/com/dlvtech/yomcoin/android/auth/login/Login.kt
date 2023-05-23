package com.dlvtech.yomcoin.android.auth.login

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.dlvtech.yomcoin.android.destinations.DashBoardDestination
import com.dlvtech.yomcoin.android.destinations.HomeScreenDestination
import com.dlvtech.yomcoin.android.destinations.SignUpDestination
import com.dlvtech.yomcoin.api_consume.ServerUtils
import com.dlvtech.yomcoin.api_consume.weather.WeatherApi
import com.dlvtech.yomcoin.common.util.gfcntry
import com.dlvtech.yomcoin.common.util.routes
import com.dlvtech.yomcoin.defs.*
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.ktor.client.request.forms.*
//import io.ktor.client.engine.okhttp.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.androidx.compose.koinViewModel
import kotlinx.coroutines.*

@Destination
@Composable
fun Login(
    navigator: DestinationsNavigator
) {
    val context = LocalContext.current
    val viewModel: LoginViewModel = koinViewModel()
    LoginScreen(
        uiState = viewModel.uiState,
        onEmailChange = viewModel::updateEmail,
        onPasswordChange = viewModel::updatePassword,
        onSignInClick = {
                        Log.i("Logger", "Info")

            val scope = MainScope() //rememberCoroutineScope()
            var result = ""

            scope.launch {
                kotlin.runCatching {
                //    Greeting().greeting()

                    val weatherApi = WeatherApi()  //OkHttpEngine(OkHttpConfig())

                    val loginUser  = ServerUtils()

                    //result = withContext(Dispatchers.IO){ loginUser.getContent("https://www.elitepage.com.ng/rhs/user", login) }


                   // val route: String = routes().eliteApi(login)

                   //


                    val route: String = routes().gfcd(cntry)
                    Log.d("APiPath", route)

                    result = withContext(Dispatchers.IO){ loginUser.getContent(
                        route,
                        cntry,
                        Reloadly
                    )}


                    /*

                    val route: String = routes().eliteApi(signup)
                    Log.d("APiPath", route)

                    val param = FormDataContent(io.ktor.http.Parameters.build {
                        append("regId","kljnjknkjnkjnbjkkjhkhj")
                        append("Full_Name","Adeyanju David")
                        append("Essence","Profile")
                        append("Password","david123")
                    })

                    result = withContext(Dispatchers.IO){ loginUser.sendPostRequest(
                        param,
                        user,
                        Appbase
                    ) }

                     */


                    /*

                    val route: String = routes().gfcd()
                    Log.d("APiPath", route)

                    val param = FormDataContent(io.ktor.http.Parameters.build {
                        append("client_id","FeM6pmvDovnoKjG3zquUGCeLVs0g8q07")
                        append("client_secret","rHZWcUzNen-LNOkJtfM1eUon1vVIg7-cRYLNIQjYcY6v4EZWZTKcEiPhM5j6ChF")
                        append("grant_type","client_credentials")
                        append("audience","https://giftcards-sandbox.reloadly.com")
                    })

                    result = withContext(Dispatchers.IO){ loginUser.sendPostRequest(
                        param,
                        token,
                        NA
                    ) }

                     */


                    /*

                    result = withContext(Dispatchers.IO){ loginUser.postRequest(
                        route,
                        Appbase,
                        param
                    ) }

                     */







                    // result = withContext(Dispatchers.IO) { weatherApi.fetchContent() }.toString()
                    //    Toast.makeText(this@MainActivity, result.toString(), Toast.LENGTH_LONG).show()

                }.onSuccess {
                    Log.d("Login Thread", result)
                    Toast.makeText(context, result, Toast.LENGTH_LONG).show()
                    navigator.navigate(DashBoardDestination){
                        popUpTo(0)
                    }
                }
                    .onFailure {
                      //  text = it.message.toString()
                        Log.d("Thread error", it.toString())
                    }
            }
                       // logger()


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
        },
        onNavigateToDashBoard = {
            navigator.navigate(DashBoardDestination){
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

        val weatherApi = WeatherApi() //OkHttpEngine(OkHttpConfig())
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
            val weatherApi = WeatherApi() //OkHttpEngine(OkHttpConfig())
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