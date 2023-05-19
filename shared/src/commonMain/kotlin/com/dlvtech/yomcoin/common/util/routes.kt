package com.dlvtech.yomcoin.common.util

import com.dlvtech.yomcoin.defs.login
import com.dlvtech.yomcoin.defs.signup

class routes {


    //https://www.elitepage.com.ng/rhs/user/entry

    fun elite(path: String): String {
        return "$base/$org/$path"
    }


    /*
    {
        "productId": 9,
        "productName": "Amazon UAE",
        "global": false,
        "senderFee": 370.0,
        "senderFeePercentage": 0.00,
        "discountPercentage": 1.2,       
        "denominationType": "FIXED",
        "recipientCurrencyCode": "AED",
        "minRecipientDenomination": null,
        "maxRecipientDenomination": null,
        "senderCurrencyCode": "NGN",
        "minSenderDenomination": null,
        "maxSenderDenomination": null,
        "fixedRecipientDenominations": [
            5.0,
            10.0,
            25.0,
            50.0,
            100.0,
            300.0
        ],
        "fixedSenderDenominations": [
            1007.63,
            2015.25,
            5038.13,
            10076.25,
            20152.51,
            60457.52
        ],
        "fixedRecipientToSenderDenominationsMap": {
            "5.0": 1007.63,
            "10.0": 2015.25,
            "25.0": 5038.13,
            "50.0": 10076.25,
            "100.0": 20152.51,
            "300.0": 60457.52
        },
        "logoUrls": [
            "https://cdn.reloadly.com/giftcards/fbef9b57-e0b0-4ead-aee3-fdc2bc80e2db.png"
        ],
        "brand": {
            "brandId": 2,
            "brandName": "Amazon"
        },
        "country": {
            "isoName": "AE",
            "name": "United Arab Emirates",
            "flagUrl": "https://s3.amazonaws.com/rld-flags/ae.svg"
        },
        "redeemInstruction": {
            "concise": "Visit www.amazon.com/redeem and enter the Claim Code when prompted.",
            "verbose": "Amazon.com Gift Cards never expire and can be redeemed towards millions of items at www.amazon.com &#13;To redeem your gift card, follow these steps: &#13;1. Visit www.amazon.com/redeem &#13;2. Enter the Claim Code when prompted. &#13;3. Gift card funds will be applied automatically to eligible orders during the checkout process. &#13;4. You must pay for any remaining balance on your order with another payment method. &#13;Your gift card claim code may also be entered when prompted during checkout. To redeem your gift card using the Amazon.com service, first add the gift card funds to Your Account. If you have questions about redeeming your gift card, please visit www.amazon.com/gc-redeem"
        }
    }
     */

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