package com.mercado.pago.integration.core.data.model.request.components

import com.google.gson.annotations.SerializedName

data class AddressRequest(
    @SerializedName("street_name") val streetName: String?,
    @SerializedName("zip_code") val zipCode: String?,
    @SerializedName("street_number") val streetNumber: Int?
)