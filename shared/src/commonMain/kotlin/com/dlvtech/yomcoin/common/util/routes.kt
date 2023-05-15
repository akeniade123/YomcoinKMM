package com.dlvtech.yomcoin.common.util

import com.dlvtech.yomcoin.defs.login
import com.dlvtech.yomcoin.defs.signup

class routes {


    //https://www.elitepage.com.ng/rhs/user/entry

    fun elite(path: String): String {
        return "$base/$org/$path"
    }

     fun eliteApi(essence: String): String
    {
        var route = ""
        when(essence)
        {
            signup ->{
                route = elite("user/entry")
            }
            login -> {
                route = elite("user")
            }

        }

        return route
    }

}