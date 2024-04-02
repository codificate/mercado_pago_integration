package com.mercado.pago.integration.core.data.model.request

import com.google.gson.annotations.SerializedName
import com.mercado.pago.integration.core.data.model.request.components.BackUrlsRequest
import com.mercado.pago.integration.core.data.model.request.components.ItemRequest
import com.mercado.pago.integration.core.data.model.request.components.PayerRequest

data class PreferencesRequest(
    @SerializedName("payer") val payer: PayerRequest?,
    @SerializedName("items") val itemRequests: List<ItemRequest>?,
    @SerializedName("back_urls") val backUrlsRequest: BackUrlsRequest?,
    @SerializedName("auto_return") val autoReturn: String?
)

