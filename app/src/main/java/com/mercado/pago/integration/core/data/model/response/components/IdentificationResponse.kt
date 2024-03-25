package com.mercado.pago.integration.core.data.model.response.components

import com.google.gson.annotations.SerializedName


data class IdentificationResponse(
    @SerializedName("number")
    val number: String?,
    @SerializedName("type")
    val type: String?
)