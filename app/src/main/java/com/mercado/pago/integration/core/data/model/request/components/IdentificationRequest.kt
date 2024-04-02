package com.mercado.pago.integration.core.data.model.request.components

import com.google.gson.annotations.SerializedName

data class IdentificationRequest(
    @SerializedName("type") val type: String?,
    @SerializedName("number") val number: String?
)