package com.dlvtech.yomcoin.api_consume


import co.touchlab.kermit.Kermit
import com.dlvtech.yomcoin.api_consume.weather.RequestAnalysis
import com.dlvtech.yomcoin.auth.data.eliteapi.defaultResponse
import com.dlvtech.yomcoin.auth.data.eliteapi.userData.Data
import com.dlvtech.yomcoin.auth.data.eliteapi.userData.User
import com.dlvtech.yomcoin.defs.Appbase
import com.dlvtech.yomcoin.defs.Reloadly
import com.dlvtech.yomcoin.defs.login
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

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
                    headers {
                        append(HttpHeaders.Accept, "*/*")
                        append(HttpHeaders.Authorization, "Bearer eyJraWQiOiJjNGE1ZWU1Zi0xYmE2LTQ1N2UtOTI3Yi1lYzdiODliNzcxZTIiLCJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxOTU3OSIsImlzcyI6Imh0dHBzOi8vcmVsb2FkbHktc2FuZGJveC5hdXRoMC5jb20vIiwiaHR0cHM6Ly9yZWxvYWRseS5jb20vc2FuZGJveCI6dHJ1ZSwiaHR0cHM6Ly9yZWxvYWRseS5jb20vcHJlcGFpZFVzZXJJZCI6IjE5NTc5IiwiZ3R5IjoiY2xpZW50LWNyZWRlbnRpYWxzIiwiYXVkIjoiaHR0cHM6Ly9naWZ0Y2FyZHMtc2FuZGJveC5yZWxvYWRseS5jb20iLCJuYmYiOjE2ODQ4Mjg5NjksImF6cCI6IjE5NTc5Iiwic2NvcGUiOiJkZXZlbG9wZXIiLCJleHAiOjE2ODQ5MTUzNjksImh0dHBzOi8vcmVsb2FkbHkuY29tL2p0aSI6IjVhZTg2YTJlLWFjYjktNGJlMS1hMTc1LWU2OTQwMWNmMWZhMSIsImlhdCI6MTY4NDgyODk2OSwianRpIjoiNzI3ODIzNmEtZWI4Mi00OGNiLTliNmMtNzg1YjcyMGE0M2YzIn0.NzlERQGNlcpczDFze20NR8TmD68MrCPWfWk4nqDVigg")

                        // append(HttpHeaders.UserAgent, "ktor client")
                    }
                    //Authorization
                    //https://giftcards-sandbox.reloadly.com/countries/AE/products
                }
            }


        }
        /*
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

         */

        return RequestAnalysis().Analyze(essence, response)

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


    suspend fun sendPostRequest (requestBody: FormDataContent, essence:String, domain:String): String
    {
        try
        {
            val response = client!!.post {
                url("https://www.elitepage.com.ng/rhs/user/entry")

                /*
                    parameter("infoType", infoType)
                    parameter("task", task)
                 */

                when(domain)
                {
                    Appbase -> {
                        headers {
                            append(HttpHeaders.Accept, "*/*")
                            append("authentication", "937a4a8c13e317dfd28effdd479cad2f")
                        }
                    }
                }

                setBody(requestBody)

            }
            return RequestAnalysis().Analyze(essence, response)
        }
        catch (e: Exception)
        {
            //Log.d("DEBUG_DATA", "https exception: ${e.toString()}")
            return e.toString()
        }
    }


    //suspend fun postRequest(Url: String, essence: String, engine: HttpClientEngine, requestBody: FormDataContent) : HttpResponse
    suspend fun postRequest(Url: String, essence: String,  requestBody: FormDataContent) : String
    {
       // val client = HttpClient(engine)
        val response: HttpResponse = client.post() {
            url{
                encodedPath = Url
                contentType(ContentType.Application.FormUrlEncoded)
            }
            when(essence)
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


       // Log.v("Ktor", "Hello")

        val kermit = Kermit()



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
                kermit.i({ ee.message.toString() })
            }
        }

        kermit.i({ resp })
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




