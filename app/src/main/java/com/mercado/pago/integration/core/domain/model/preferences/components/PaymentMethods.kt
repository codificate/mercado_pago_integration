package com.mercado.pago.integration.core.domain.model.preferences.components

data class PaymentMethods(
    val defaultCardId: Any?,
    val defaultInstallments: Any?,
    val defaultPaymentMethodId: Any?,
    val excludedPaymentMethods: List<ExcludedPaymentMethod?>?,
    val excludedPaymentTypes: List<ExcludedPaymentType?>?,
    val installments: Any?
)