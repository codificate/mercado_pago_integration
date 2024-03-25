package com.mercado.pago.integration.core.domain.model.preferences.components

data class RedirectUrls(
    val failure: String?,
    val pending: String?,
    val success: String?
)