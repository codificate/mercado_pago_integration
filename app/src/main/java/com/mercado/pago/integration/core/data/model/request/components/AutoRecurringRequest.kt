package com.mercado.pago.integration.core.data.model.request.components

import com.google.gson.annotations.SerializedName

data class AutoRecurringRequest(
    @SerializedName("currency_id")
    val currencyIdRequest: String,

    @SerializedName("frequency")
    val frequencyRequest: Int,

    @SerializedName("frequency_type")
    val frequencyTypeRequest: String,

    @SerializedName("transaction_amount")
    val transactionAmountRequest: Int
)