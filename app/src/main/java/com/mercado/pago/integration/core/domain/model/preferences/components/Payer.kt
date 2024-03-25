package com.mercado.pago.integration.core.domain.model.preferences.components

data class Payer(
    val address: Address?,
    val dateCreated: Any?,
    val email: String?,
    val identification: Identification?,
    val lastPurchase: Any?,
    val name: String?,
    val phone: Phone?,
    val surname: String?
)