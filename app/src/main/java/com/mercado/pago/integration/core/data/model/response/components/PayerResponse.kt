package com.mercado.pago.integration.core.data.model.response.components

import com.google.gson.annotations.SerializedName


data class PayerResponse(
    @SerializedName("address")
    val addressResponse: AddressResponse?,
    @SerializedName("date_created")
    val dateCreated: Any?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("identification")
    val identificationResponse: IdentificationResponse?,
    @SerializedName("last_purchase")
    val lastPurchase: Any?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("phone")
    val phoneResponse: PhoneResponse?,
    @SerializedName("surname")
    val surname: String?
)