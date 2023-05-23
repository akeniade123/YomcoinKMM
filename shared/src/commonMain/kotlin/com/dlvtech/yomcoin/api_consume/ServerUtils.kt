package com.dlvtech.yomcoin.api_consume


import com.dlvtech.yomcoin.auth.data.eliteapi.defaultResponse
import com.dlvtech.yomcoin.auth.data.eliteapi.userData.Data
import com.dlvtech.yomcoin.auth.data.eliteapi.userData.User
import com.dlvtech.yomcoin.defs.Appbase
import com.dlvtech.yomcoin.defs.Reloadly
import com.dlvtech.yomcoin.defs.login
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


import io.ktor.client.request.forms.*
import kotlinx.serialization.json.JsonObject

/*
import formparameters.*
import e2e.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.application.*
import kotlinx.coroutines.*

 */



class ServerUtils {

    private val client = HttpClient()

    suspend fun getContent(url: String, essence: String, domain: String): String {
        val response: HttpResponse = client.get(url) {

            when(domain)
            {
                Appbase -> {
                    headers {
                        append(HttpHeaders.Accept, "*/*")
                        append("authentication", "937a4a8c13e317dfd28effdd479cad2f")

                        // append(HttpHeaders.UserAgent, "ktor client")
                    }
                }

                Reloadly ->{

                    //https://giftcards-sandbox.reloadly.com/countries/AE/products
                }


            }


        }
        var resp = ""

        try {
            val obj = Json.decodeFromString<User>(response.bodyAsText())
            val stt: Boolean = obj.status
            val msg: String  = obj.message
            val dtt: List<Data> = obj.data

            resp = msg

            when(essence)
            {
                login -> {
                    if(stt)
                    {
                        for (i in 0 until obj.data.size) {
                            dtt[i]
                        }
                    }
                }
            }

        }
        catch (e: Exception)
        {
            try{
                val obj = Json.decodeFromString<defaultResponse>(response.bodyAsText())
                val stt: Boolean = obj.status
                val msg: String  = obj.message
                if(!stt)
                {
                    resp = msg
                }
            }
            catch (ee: Exception)
            {
            }
        }
        return  resp
    }




    /*
    private val client by lazy {
        HttpClient(engine) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(JSON.nonstrict)
            }
        }
    }

    suspend fun fetchWeather(): Weather {
        return client.get {
            url("$baseUrl/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
        }
    }

    companion object {
        private const val baseUrl = "https://samples.openweathermap.org"
    }
     */



    fun getHeader(essence: String)
    {
        when(essence)
        {
            Appbase -> {

            }
        }
    }

    suspend fun postEntity()
    {

    }


    suspend fun postRequest(Url: String, essence: String, engine: HttpClientEngine, requestBody: FormDataContent)
    {
       // val client = HttpClient(engine)

        val response: HttpResponse = client.post() {
            url{
                encodedPath = Url
                contentType(ContentType.Application.FormUrlEncoded)
            }
            headers {
                append(HttpHeaders.Accept, "*/*")
                append("X-CoinAPI-Key", "2F9718FF-FB0B-433F-A59F-D147B79F22EA")
                // append(HttpHeaders.UserAgent, "ktor client")
            }
            setBody(requestBody)
            //setBody(data)
            /*
            body = FormDataContent(Parameters.build {
                append("param1", "lorem")
                append("param2", "ipsum")
            })

             */

            /*
            formParameters = Parameters.build {
                append("first_name", "Jet")
                append("last_name", "Brains")
            },
            encodeInQuery = true

             */
        }
    }


    suspend fun getCrypto(url: String) : HttpResponse
    {
        val response: HttpResponse = client.get(url) {
            headers {
                append(HttpHeaders.Accept, "*/*")
                append("X-CoinAPI-Key", "2F9718FF-FB0B-433F-A59F-D147B79F22EA")
                // append(HttpHeaders.UserAgent, "ktor client")
            }
        }
        return  response
    }

}