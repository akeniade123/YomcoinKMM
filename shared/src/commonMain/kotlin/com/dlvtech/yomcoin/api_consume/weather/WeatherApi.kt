package com.dlvtech.yomcoin.api_consume.weather


import io.ktor.client.HttpClient
import io.ktor.client.engine.*
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.statement.*

import kotlinx.serialization.Serializable

class WeatherApi() {

    //private val engine: HttpClientEngine

    private val client = HttpClient()

    /*
    private val client by lazy {
        HttpClient(engine) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(JSON.nonstrict)
            }
        }
    }
     */

    suspend fun fetchWeather(): HttpResponse {
        val response = client.get("$baseUrl/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
        return  response
            /*
        return client.get {
            url("$baseUrl/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
        }

             */
    }


    suspend fun fetchContent(): String {
        val response = client.get("$baseUrl/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
        return  response.bodyAsText()
        /*
    return client.get {
        url("$baseUrl/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
    }

         */
    }

    companion object {
        private const val baseUrl = "https://samples.openweathermap.org"
    }



}

    /*
    private val client = HttpClient()
    suspend fun fetchWeather(): String {
        return client.get<String> {
            url("$baseUrl/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
        }
    }
    companion object {
        private const val baseUrl = "https://samples.openweathermap.org"
    }

     */
