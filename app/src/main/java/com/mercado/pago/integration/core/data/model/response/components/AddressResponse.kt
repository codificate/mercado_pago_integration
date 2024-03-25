package com.mercado.pago.integration.core.data.model.response.components


import com.google.gson.annotations.SerializedName

data class AddressResponse(
    @SerializedName("street_name")
    val streetName: String?,
    @SerializedName("street_number")
    val streetNumber: Any?,
    @SerializedName("zip_code")
    val zipCode: String?
)