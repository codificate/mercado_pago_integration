package com.mercado.pago.integration.core.data.model.response.components

import com.google.gson.annotations.SerializedName


data class PaymentMethodsResponse(
    @SerializedName("default_card_id")
    val defaultCardId: Any?,
    @SerializedName("default_installments")
    val defaultInstallments: Any?,
    @SerializedName("default_payment_method_id")
    val defaultPaymentMethodId: Any?,
    @SerializedName("excluded_payment_methods")
    val excludedPaymentMethodResponses: List<ExcludedPaymentMethodResponse>,
    @SerializedName("excluded_payment_types")
    val excludedPaymentTypeResponses: List<ExcludedPaymentTypeResponse>,
    @SerializedName("installments")
    val installments: Any?
)