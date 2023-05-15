 package com.dlvtech.yomcoin.android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dlvtech.yomcoin.Greeting
import com.dlvtech.yomcoin.android.common.theming.SocialAppTheme

import android.widget.Toast
import androidx.compose.runtime.*
import com.dlvtech.yomcoin.api_consume.weather.WeatherApi
/*
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
*/


/*

import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.engine.okhttp.OkHttpEngine

import io.ktor.client.engine.*

 */

import kotlinx.coroutines.*
//import okhttp3.logging.HttpLoggingInterceptor
import kotlin.coroutines.CoroutineContext
//import com.facebook.stetho.Stetho
//import com.squareup.sqldelight.android.AndroidSqliteDriver

import kotlinx.coroutines.CoroutineScope


 class MainActivity : ComponentActivity() {
     @SuppressLint("CoroutineCreationDuringComposition")
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContent {
             SocialAppTheme {
                 Surface(
                     modifier = Modifier.fillMaxSize(),
                     color = MaterialTheme.colors.background
                 ) {
                     val scope = MainScope() //rememberCoroutineScope()
                     var text by remember { mutableStateOf("Loading") }

                     scope.launch {
                         kotlin.runCatching {
                             Greeting().greeting()
                         }.onSuccess {
                             text = it
                         }
                             .onFailure {
                                 text = it.message.toString()
                             }
                     }
                     /*
                     LaunchedEffect(true) {
                         scope.launch {
                             text = try {
                                 Greeting().greeting()
                             } catch (e: Exception) {
                                 e.localizedMessage ?: "error"
                             }

                         }

                       //  GreetingView(text)
                     }

                      */

                 //    GreetingView(Greeting().greet())


                    // GreetingView(text)
                      SocialApp()
                 }
             }
         }
     }


     /*

 class MainActivity : AppCompatActivity(), CoroutineScope {
     private val job = Job()
     override val coroutineContext: CoroutineContext
         get() = job
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         val weatherApi = WeatherApi(OkHttpEngine(OkHttpConfig()))
         launch(Dispatchers.Main) {
             try {
                 val result = withContext(Dispatchers.IO) { weatherApi.fetchWeather() }
                 Toast.makeText(this@MainActivity, result.toString(), Toast.LENGTH_LONG).show()
             } catch (e: Exception) {
                 e.printStackTrace()
                 Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
             }
         }
     }
 }

  */

     @Composable
     fun GreetingView(text: String) {
         Text(text = text)
     }

     @Preview
     @Composable
     fun DefaultPreview() {
         MyApplicationTheme {
             GreetingView("Hello, Android!")
         }
     }
 }
