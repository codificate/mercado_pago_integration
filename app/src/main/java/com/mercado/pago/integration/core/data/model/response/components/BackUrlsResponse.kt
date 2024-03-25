package com.mercado.pago.integration.core.data.model.response.components

import com.google.gson.annotations.SerializedName

data class BackUrlsResponse(
    @SerializedName("failure")
    val failure: String?,
    @SerializedName("pending")
    val pending: String?,
    @SerializedName("success")
    val success: String?
)