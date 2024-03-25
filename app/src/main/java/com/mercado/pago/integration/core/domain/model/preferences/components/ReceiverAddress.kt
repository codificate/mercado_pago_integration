package com.mercado.pago.integration.core.domain.model.preferences.components

data class ReceiverAddress(
    val apartment: String?,
    val cityName: Any?,
    val countryName: Any?,
    val floor: String?,
    val stateName: Any?,
    val streetName: String?,
    val streetNumber: Any?,
    val zipCode: String?
)