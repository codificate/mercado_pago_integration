package com.mercado.pago.integration.core.domain.model.preferences.components

data class Item(
    val categoryId: String?,
    val currencyId: String?,
    val description: String?,
    val id: String?,
    val pictureUrl: String?,
    val quantity: Int?,
    val title: String?,
    val unitPrice: Int?
)