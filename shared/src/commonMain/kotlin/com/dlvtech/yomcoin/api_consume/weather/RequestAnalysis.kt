package com.dlvtech.yomcoin.api_consume.weather

import com.dlvtech.yomcoin.auth.data.eliteapi.userData.Data
import com.dlvtech.yomcoin.auth.data.eliteapi.userData.User
import com.dlvtech.yomcoin.defs.cntry
import com.dlvtech.yomcoin.defs.token
import com.dlvtech.yomcoin.defs.user
import com.dlvtech.yomcoin.model.giftcard.token
import db.GiftCard
import io.ktor.client.statement.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class RequestAnalysis {

    suspend fun Analyze(essence: String, response: HttpResponse): String
    {
        var resp = ""
        try{
            when(essence)
            {
                token -> {

                    /*
                    val obj = Json.decodeFromString<token>(response.bodyAsText())
                    val act: String = obj.access_token
                    val exp: Int  = obj.expires_in
                    val scp: String = obj.scope
                    val tkn: String = obj.token_type
                     */


                    resp = response.bodyAsText().toString()
                }

                user -> {
                    val obj = Json.decodeFromString<User>(response.bodyAsText())
                    val stt: Boolean = obj.status
                    val msg: String  = obj.message
                    val dtt: List<Data> = obj.data
                    resp = msg
                }

                cntry-> {
                    val obj = Json.decodeFromString<GiftCard>(response.bodyAsText())
                    resp = obj.productName
                }
            }
        }
        catch (e:Exception)
        {
            resp = e.toString()
        }

        return  resp
    }

}