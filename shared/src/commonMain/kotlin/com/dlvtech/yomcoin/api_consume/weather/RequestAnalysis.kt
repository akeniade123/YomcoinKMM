package com.dlvtech.yomcoin.api_consume.weather

import com.dlvtech.yomcoin.auth.data.eliteapi.userData.Data
import com.dlvtech.yomcoin.auth.data.eliteapi.userData.User
import com.dlvtech.yomcoin.defs.*
import com.dlvtech.yomcoin.model.giftcard.giftcardTerrain.Balance

import com.dlvtech.yomcoin.model.giftcard.giftcardTerrain.giftCardsItem
import com.dlvtech.yomcoin.model.giftcard.token
import com.dlvtech.yomcoin.model.users.Users
import io.ktor.client.statement.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class RequestAnalysis {

    suspend fun Analyze(essence: String, response: HttpResponse): Any
    {
        var resp = ""
        try{
            when(essence)
            {
                Token -> {

                    val obj = Json.decodeFromString<token>(response.bodyAsText())
                    val act: String = obj.access_token
                    val exp: Int  = obj.expires_in
                    val scp: String = obj.scope
                    val tkn: String = obj.token_type

                    return response.bodyAsText().toString()
                }

                user -> {
                    val obj = Json.decodeFromString<User>(response.bodyAsText())


                    val stt: Boolean = obj.status
                    val msg: String  = obj.message
                    val dtt: List<Data> = obj.data

                    return obj
                }

                users -> {
                  //  return response.bodyAsText()
                    return Json.decodeFromString<Users>(response.bodyAsText())
                }

                bal -> {
                    val obj = Json.decodeFromString<Balance>(response.bodyAsText())
                    return obj
                }

                cntry -> {
                    // val dataList = listOf(Data(42, "str"), Data(12, "test"))
                    // val jsonList = Json.encodeToString(obj)

                    /*
                    val kermit = Kermit()
                    kermit.i { "Hello $rcc.size" }

                     */

                   // return response.bodyAsText()
                    return Json.decodeFromString<List<giftCardsItem>>(response.bodyAsText())
                }


            }
        }
        catch (e:Exception)
        {
            return e.toString()
        }
        return NA
    }
}