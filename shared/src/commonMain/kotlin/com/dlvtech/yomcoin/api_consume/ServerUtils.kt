package com.dlvtech.yomcoin.api_consume


import com.dlvtech.yomcoin.auth.data.eliteapi.defaultResponse
import com.dlvtech.yomcoin.auth.data.eliteapi.userData.Data
import com.dlvtech.yomcoin.auth.data.eliteapi.userData.User
import com.dlvtech.yomcoin.defs.login
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ServerUtils {

    private val client = HttpClient()

    suspend fun getContent(url: String, essence: String): String {
        val response: HttpResponse = client.get(url) {
            headers {
                append(HttpHeaders.Accept, "*/*")
                append("authentication", "937a4a8c13e317dfd28effdd479cad2f")
               // append(HttpHeaders.UserAgent, "ktor client")
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