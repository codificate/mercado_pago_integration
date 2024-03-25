package com.mercado.pago.integration.core.data.model.request

import com.google.gson.annotations.SerializedName
import com.mercado.pago.integration.core.data.model.request.components.BackUrlsRequest
import com.mercado.pago.integration.core.data.model.request.components.ItemRequest

data class PreferencesRequest(
    @SerializedName("payer_email") val payerEmailRequest: String?,
    @SerializedName("items") val itemRequests: List<ItemRequest>?,
    @SerializedName("back_urls") val backUrlsRequest: BackUrlsRequest?,
    @SerializedName("auto_return") val autoReturn: String?
)

