package com.mercado.pago.integration.core.domain.model.preferences

import com.mercado.pago.integration.core.domain.model.preferences.components.BackUrls
import com.mercado.pago.integration.core.domain.model.preferences.components.Item
import com.mercado.pago.integration.core.domain.model.preferences.components.Payer
import com.mercado.pago.integration.core.domain.model.preferences.components.PaymentMethods
import com.mercado.pago.integration.core.domain.model.preferences.components.RedirectUrls
import com.mercado.pago.integration.core.domain.model.preferences.components.Shipments
import com.mercado.pago.integration.core.domain.model.preferences.components.Metadata

data class Preferences(
    val additionalInfo: String?,
    val autoReturn: String?,
    val backUrls: BackUrls?,
    val binaryMode: Boolean?,
    val clientId: String?,
    val collectorId: Int?,
    val couponCode: Any?,
    val couponLabels: Any?,
    val dateCreated: String?,
    val dateOfExpiration: Any?,
    val expirationDateFrom: Any?,
    val expirationDateTo: Any?,
    val expires: Boolean?,
    val externalReference: String?,
    val id: String?,
    val initPoint: String?,
    val internalMetadata: Any?,
    val items: List<Item?>?,
    val lastUpdated: Any?,
    val marketplace: String?,
    val marketplaceFee: Int?,
    val metadata: Metadata?,
    val notificationUrl: Any?,
    val operationType: String?,
    val payerResponse: Payer?,
    val paymentMethods: PaymentMethods?,
    val processingModes: Any?,
    val productId: Any?,
    val redirectUrls: RedirectUrls?,
    val sandboxInitPoint: String?,
    val shipments: Shipments?,
    val siteId: String?,
    val totalAmount: Any?
)