package com.dlvtech.yomcoin.model.giftcard.giftcardTerrain

import kotlinx.serialization.Serializable


@Serializable
data class giftCardsItem(
    val brand: Brand,
    val country: Country,
    val denominationType: String,
    val discountPercentage: Double,
    val fixedRecipientDenominations: List<Double>,
    //val fixedRecipientToSenderDenominationsMap: FixedRecipientToSenderDenominationsMap,
    val fixedSenderDenominations: List<Double>,
    val global: Boolean,
    val logoUrls: List<String>,
  //  val maxRecipientDenomination: Double,
  //  val maxSenderDenomination: Double,
  //  val minRecipientDenomination: Double,
  //  val minSenderDenomination: Double,
    val productId: Int,
    val productName: String,
    val recipientCurrencyCode: String,
    val redeemInstruction: RedeemInstruction,
    val senderCurrencyCode: String,
    val senderFee: Double,
    val senderFeePercentage: Double
)