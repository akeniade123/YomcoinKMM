package com.dlvtech.yomcoin.api_consume

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class ServerUtils {

    private val client = HttpClient()

    suspend fun getContent(url: String): String {
        val response: HttpResponse = client.get(url) {
            headers {
                append(HttpHeaders.Accept, "*/*")
                append("authentication", "937a4a8c13e317dfd28effdd479cad2f")
               // append(HttpHeaders.UserAgent, "ktor client")
            }
        }
        return  response.bodyAsText()
    }

}