package com.mercado.pago.integration.core.data.model.response

import com.google.gson.annotations.SerializedName
import com.mercado.pago.integration.core.data.model.response.components.BackUrlsResponse
import com.mercado.pago.integration.core.data.model.response.components.ItemResponse
import com.mercado.pago.integration.core.data.model.response.components.MetadataResponse
import com.mercado.pago.integration.core.data.model.response.components.PayerResponse
import com.mercado.pago.integration.core.data.model.response.components.PaymentMethodsResponse
import com.mercado.pago.integration.core.data.model.response.components.RedirectUrlsResponse
import com.mercado.pago.integration.core.data.model.response.components.ShipmentsResponse

data class PreferencesResponse(
    @SerializedName("additional_info")
    val additionalInfo: String?,
    @SerializedName("auto_return")
    val autoReturn: String?,
    @SerializedName("back_urls")
    val backUrlsResponse: BackUrlsResponse?,
    @SerializedName("binary_mode")
    val binaryMode: Boolean?,
    @SerializedName("client_id")
    val clientId: String?,
    @SerializedName("collector_id")
    val collectorId: Int?,
    @SerializedName("coupon_code")
    val couponCode: Any?,
    @SerializedName("coupon_labels")
    val couponLabels: Any?,
    @SerializedName("date_created")
    val dateCreated: String?,
    @SerializedName("date_of_expiration")
    val dateOfExpiration: Any?,
    @SerializedName("expiration_date_from")
    val expirationDateFrom: Any?,
    @SerializedName("expiration_date_to")
    val expirationDateTo: Any?,
    @SerializedName("expires")
    val expires: Boolean?,
    @SerializedName("external_reference")
    val externalReference: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("init_point")
    val initPoint: String?,
    @SerializedName("internal_metadata")
    val internalMetadata: Any?,
    @SerializedName("items")
    val itemResponses: List<ItemResponse>,
    @SerializedName("last_updated")
    val lastUpdated: Any?,
    @SerializedName("marketplace")
    val marketplace: String?,
    @SerializedName("marketplace_fee")
    val marketplaceFee: Int?,
    @SerializedName("metadata")
    val metadataResponse: MetadataResponse?,
    @SerializedName("notification_url")
    val notificationUrl: Any?,
    @SerializedName("operation_type")
    val operationType: String?,
    @SerializedName("payer")
    val payerResponse: PayerResponse?,
    @SerializedName("payment_methods")
    val paymentMethodsResponse: PaymentMethodsResponse?,
    @SerializedName("processing_modes")
    val processingModes: Any?,
    @SerializedName("product_id")
    val productId: Any?,
    @SerializedName("redirect_urls")
    val redirectUrlsResponse: RedirectUrlsResponse?,
    @SerializedName("sandbox_init_point")
    val sandboxInitPointResponse: String?,
    @SerializedName("shipments")
    val shipmentsResponse: ShipmentsResponse?,
    @SerializedName("site_id")
    val siteIdResponse: String?,
    @SerializedName("total_amount")
    val totalAmountResponse: Any?
)