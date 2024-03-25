package com.mercado.pago.integration.core.data.model.request.components

import com.google.gson.annotations.SerializedName

data class ItemRequest(
    @SerializedName("title") val titleRequest: String,
    @SerializedName("description") val descriptionRequest: String,
    @SerializedName("picture_url") val pictureUrlRequest: String,
    @SerializedName("category_id") val categoryIdRequest: String,
    @SerializedName("quantity") val quantityRequest: Int,
    @SerializedName("currency_id") val currencyIdRequest: String,
    @SerializedName("unit_price") val unitPriceRequest: Int
)

