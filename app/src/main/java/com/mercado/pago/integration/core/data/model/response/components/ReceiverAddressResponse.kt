package com.mercado.pago.integration.core.data.model.response.components

import com.google.gson.annotations.SerializedName

data class ReceiverAddressResponse(
    @SerializedName("apartment")
    val apartment: String?,
    @SerializedName("city_name")
    val cityName: Any?,
    @SerializedName("country_name")
    val countryName: Any?,
    @SerializedName("floor")
    val floor: String?,
    @SerializedName("state_name")
    val stateName: Any?,
    @SerializedName("street_name")
    val streetName: String?,
    @SerializedName("street_number")
    val streetNumber: Any?,
    @SerializedName("zip_code")
    val zipCode: String?
)