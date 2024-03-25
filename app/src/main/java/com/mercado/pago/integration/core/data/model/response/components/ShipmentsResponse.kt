package com.mercado.pago.integration.core.data.model.response.components

import com.google.gson.annotations.SerializedName

data class ShipmentsResponse(
    @SerializedName("default_shipping_method")
    val defaultShippingMethod: Any?,
    @SerializedName("receiver_address")
    val receiverAddressResponse: ReceiverAddressResponse?
)