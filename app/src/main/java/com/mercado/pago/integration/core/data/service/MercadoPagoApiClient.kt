package com.mercado.pago.integration.core.data.service

import com.mercado.pago.integration.core.data.model.request.PreferencesRequest
import com.mercado.pago.integration.core.data.model.request.SubscriptionRequest
import com.mercado.pago.integration.core.data.model.response.PreferencesResponse
import com.mercado.pago.integration.core.data.model.response.SubscriptionResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MercadoPagoApiClient {
    @POST("checkout/preferences")
    suspend fun createPreferences(@Body request: PreferencesRequest): Response<PreferencesResponse>

    @POST("preapproval")
    suspend fun createSubscription(@Body request: SubscriptionRequest): Response<SubscriptionResponse>

}