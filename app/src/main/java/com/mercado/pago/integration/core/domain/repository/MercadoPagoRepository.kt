package com.mercado.pago.integration.core.domain.repository

import com.mercado.pago.integration.core.data.common.ApiState
import com.mercado.pago.integration.core.domain.model.preferences.Preferences
import com.mercado.pago.integration.core.domain.model.subscription.Subscription

interface MercadoPagoRepository {
    suspend fun createPreferences(): ApiState<Preferences>
    suspend fun createSubscription(): ApiState<Subscription>
}