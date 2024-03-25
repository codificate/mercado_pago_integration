package com.mercado.pago.integration.core.data.model.request

import com.google.gson.annotations.SerializedName
import com.mercado.pago.integration.core.data.model.request.components.AutoRecurringRequest

data class SubscriptionRequest(
    @SerializedName("auto_recurring") val autoRecurringRequest: AutoRecurringRequest,
    @SerializedName("back_url") val backUrlRequest: String,
    @SerializedName("payer_email") val payerEmailRequest: String,
    @SerializedName("reason") val reasonRequest: String
)