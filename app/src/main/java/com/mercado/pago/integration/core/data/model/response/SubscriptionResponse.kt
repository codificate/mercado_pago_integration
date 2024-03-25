package com.mercado.pago.integration.core.data.model.response

import com.google.gson.annotations.SerializedName
import com.mercado.pago.integration.core.data.model.response.components.AutoRecurringResponse
import com.mercado.pago.integration.core.data.model.response.components.SummarizedResponse

data class SubscriptionResponse(
    @SerializedName("application_id")
    val applicationIdResponse: Long,

    @SerializedName("auto_recurring")
    val autoRecurringResponse: AutoRecurringResponse,

    @SerializedName("back_url")
    val backUrlResponse: String,

    @SerializedName("collector_id")
    val collectorIdResponse: Int,

    @SerializedName("date_created")
    val dateCreatedResponse: String,

    @SerializedName("first_invoice_offset")
    val firstInvoiceOffsetResponse: Any?,

    @SerializedName("id")
    val idResponse: String,

    @SerializedName("init_point")
    val initPointResponse: String,

    @SerializedName("last_modified")
    val lastModifiedResponse: String,

    @SerializedName("payer_email")
    val payerEmailResponse: String,

    @SerializedName("payer_id")
    val payerIdResponse: Int,

    @SerializedName("payment_method_id")
    val paymentMethodIdResponse: Any?,

    @SerializedName("reason")
    val reasonResponse: String,

    @SerializedName("status")
    val statusResponse: String,

    @SerializedName("summarized")
    val summarizedResponse: SummarizedResponse
)