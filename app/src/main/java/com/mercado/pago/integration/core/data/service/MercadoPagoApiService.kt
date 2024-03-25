package com.mercado.pago.integration.core.data.service

import com.mercado.pago.integration.core.data.model.request.PreferencesRequest
import com.mercado.pago.integration.core.data.model.request.SubscriptionRequest
import com.mercado.pago.integration.core.data.model.response.PreferencesResponse
import com.mercado.pago.integration.core.data.model.response.SubscriptionResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MercadoPagoApiService(private val client: MercadoPagoApiClient) {

    suspend fun createPreferences(preferencesRequest: PreferencesRequest): PreferencesResponse? {
        return withContext(Dispatchers.IO) {
            val response = client.createPreferences(preferencesRequest)
            response.body()
        }
    }

    suspend fun createSubscription(subscriptionRequest: SubscriptionRequest): SubscriptionResponse? {
        return withContext(Dispatchers.IO) {
            val response = client.createSubscription(subscriptionRequest)
            response.body()
        }
    }
}