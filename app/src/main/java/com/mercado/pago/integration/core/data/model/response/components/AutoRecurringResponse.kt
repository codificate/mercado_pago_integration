package com.mercado.pago.integration.core.data.model.response.components

import com.google.gson.annotations.SerializedName

data class AutoRecurringResponse(
    @SerializedName("currency_id")
    val currencyIdResponse: String,

    @SerializedName("free_trial")
    val freeTrialResponse: Any?,

    @SerializedName("frequency")
    val frequencyResponse: Int,

    @SerializedName("frequency_type")
    val frequencyTypeResponse: String,

    @SerializedName("transaction_amount")
    val transactionAmountResponse: Int?
)