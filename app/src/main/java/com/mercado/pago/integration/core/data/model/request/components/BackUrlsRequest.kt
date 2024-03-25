package com.mercado.pago.integration.core.data.model.request.components

import com.google.gson.annotations.SerializedName

data class BackUrlsRequest(
    @SerializedName("failure") val failureRequest: String,
    @SerializedName("pending") val pendingRequest: String,
    @SerializedName("success") val successRequest: String
)