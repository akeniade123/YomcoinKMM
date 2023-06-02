 package com.dlvtech.yomcoin.android

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.FrameLayout
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
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.dlvtech.yomcoin.api_consume.weather.WeatherApi
import com.dlvtech.yomcoin.common.App
import com.dlvtech.yomcoin.sqldelight.SpaceXSDK
import com.dlvtech.yomcoin.sqldelight.cache.DatabaseDriverFactory
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



 /*

 class MainActivity : AppCompatActivity() {
     private val mainScope = MainScope()

     private lateinit var launchesRecyclerView: RecyclerView
     private lateinit var progressBarView: FrameLayout
     private lateinit var swipeRefreshLayout: SwipeRefreshLayout

     private val sdk = SpaceXSDK(DatabaseDriverFactory(this))

     private val launchesRvAdapter = LaunchesRvAdapter(listOf())

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         title = "SpaceX Launches"
         setContentView(R.layout.activity_main)

         launchesRecyclerView = findViewById(R.id.launchesListRv)
         progressBarView = findViewById(R.id.progressBar)
         swipeRefreshLayout = findViewById(R.id.swipeContainer)

         launchesRecyclerView.adapter = launchesRvAdapter
         launchesRecyclerView.layoutManager = LinearLayoutManager(this)

         swipeRefreshLayout.setOnRefreshListener {
             swipeRefreshLayout.isRefreshing = false
             displayLaunches(true)
         }

         displayLaunches(false)
     }

     override fun onDestroy() {
         super.onDestroy()
         mainScope.cancel()
     }

     private fun displayLaunches(needReload: Boolean) {
         progressBarView.isVisible = true
         mainScope.launch {
             kotlin.runCatching {
                 sdk.getLaunches(needReload)
             }.onSuccess {
                 launchesRvAdapter.launches = it
                 launchesRvAdapter.notifyDataSetChanged()
             }.onFailure {
                 Toast.makeText(this@MainActivity, it.localizedMessage, Toast.LENGTH_SHORT).show()
             }
             progressBarView.isVisible = false
         }
     }
 }


  */


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


                     /*

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

                      */
                    // SocialApp()

                     App()

                 }
             }
         }
     }

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

