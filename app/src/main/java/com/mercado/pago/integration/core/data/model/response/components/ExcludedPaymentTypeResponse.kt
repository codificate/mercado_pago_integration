package com.mercado.pago.integration.core.data.model.response.components

import com.google.gson.annotations.SerializedName


data class ExcludedPaymentTypeResponse(
    @SerializedName("id")
    val id: String?
)