package com.mercado.pago.integration.core.domain.model.subscription.components

data class AutoRecurring(
    val currencyId: String,
    val freeTrial: Any?,
    val frequency: Int,
    val frequencyType: String,
    val transactionAmount: Int?
)