package com.mercado.pago.integration.core.data.model.request.components

import com.google.gson.annotations.SerializedName

data class PhoneRequest(
    @SerializedName("area_code") val areaCode: String?,
    @SerializedName("number") val number: String?
)