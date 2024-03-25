package com.mercado.pago.integration.core.data.model.response.components

import com.google.gson.annotations.SerializedName


data class SummarizedResponse(
    @SerializedName("charged_amount")
    val chargedAmount: Any?,

    @SerializedName("charged_quantity")
    val chargedQuantity: Any?,

    @SerializedName("last_charged_amount")
    val lastChargedAmount: Any?,

    @SerializedName("last_charged_date")
    val lastChargedDate: Any?,

    @SerializedName("pending_charge_amount")
    val pendingChargeAmount: Any?,

    @SerializedName("pending_charge_quantity")
    val pendingChargeQuantity: Any?,

    @SerializedName("quotas")
    val quotas: Any?,

    @SerializedName("semaphore")
    val semaphore: Any?
)