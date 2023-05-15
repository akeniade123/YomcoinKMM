package com.dlvtech.yomcoin.api_consume

import com.dlvtech.yomcoin.auth.data.eliteapi.Person
import com.dlvtech.yomcoin.auth.data.eliteapi.userData.Data
import com.dlvtech.yomcoin.auth.data.eliteapi.userData.User
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

class ServerUtils {

    private val client = HttpClient()

    val login:  String = "login"
    val signup: String = "signup"

    suspend fun getContent(url: String, essence: String): String {
        val response: HttpResponse = client.get(url) {
            headers {
                append(HttpHeaders.Accept, "*/*")
                append("authentication", "937a4a8c13e317dfd28effdd479cad2f")
               // append(HttpHeaders.UserAgent, "ktor client")
            }
        }

        val resp = response.bodyAsText()

        when(essence)
        {
            login -> {
                val obj = Json.decodeFromString<User>(response.toString())

                val stt: Boolean = obj.status;
                val msg: String  = obj.message
                val dtt: List<Data> = obj.data


                if(stt)
                {
                    //Log.e()
                    for (i in 0 until obj.data.size) {
                        dtt[i]
                    }
                }



              //  println(obj)
            }
        }

        return  response.bodyAsText()
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

        try {
           // jo: JsonObject  = new JsonObject(response.bodyAsText())
        }
        catch (e: Exception)
        {

        }

        return  response
    }

}