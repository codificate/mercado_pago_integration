package com.mercado.pago.integration.core.data.model.response.components

import com.google.gson.annotations.SerializedName


data class ItemResponse(
    @SerializedName("category_id")
    val categoryId: String?,
    @SerializedName("currency_id")
    val currencyId: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("picture_url")
    val pictureUrl: String?,
    @SerializedName("quantity")
    val quantity: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("unit_price")
    val unitPrice: Int?
)