package com.mercado.pago.integration.core.data.model.response.components

import com.google.gson.annotations.SerializedName

data class PhoneResponse(
    @SerializedName("area_code")
    val areaCode: String?,
    @SerializedName("number")
    val number: String?
)