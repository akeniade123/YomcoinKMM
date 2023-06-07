package com.dlvtech.yomcoin.common.util

import com.dlvtech.yomcoin.defs.*

class routes {

    fun elite(path: String): String {
        return "$base/$org/$path"
    }

    fun gfcd(essence: String): String
    {
        var route = ""
        when(essence)
        {
            Token -> {
                route = "$gfc"
            }

            cntry -> {
                route = "$gfcntry"
            }

            bal -> {
                route = "$balance"
            }

        }

        return  route
    }


    fun cryptoApi(essence: String):String{
        var route = ""
        when(essence)
        {
            currentRate -> {
                 route = "https://rest.coinapi.io/v1/trades/latest"
            }
            trades -> {
                route = "https://rest.coinapi.io/v1/trades/latest"
            }
        }
        return route
    }


     fun eliteApi(essence: String): String
    {
        var route = ""
        when(essence)
        {
            signup ->{
                route = elite("user/entry")
            }
            user -> {
                route = elite("user")
            }
        }
        return route
    }

}