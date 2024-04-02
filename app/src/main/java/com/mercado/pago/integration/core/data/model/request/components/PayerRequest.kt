package com.mercado.pago.integration.core.data.model.request.components

import com.google.gson.annotations.SerializedName

data class PayerRequest(
    @SerializedName("address") val address: AddressRequest?,
    @SerializedName("identification") val identification: IdentificationRequest?,
    @SerializedName("phone") val phone: PhoneRequest?,
    @SerializedName("name") val name: String?,
    @SerializedName("email") val email: String?
)