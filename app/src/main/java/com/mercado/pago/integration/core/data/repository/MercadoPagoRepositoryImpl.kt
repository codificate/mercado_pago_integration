package com.mercado.pago.integration.core.data.repository

import com.mercado.pago.integration.core.data.common.ApiState
import com.mercado.pago.integration.core.data.mapper.PreferenceResponseMapperToDomain
import com.mercado.pago.integration.core.data.mapper.SubscriptionResponseMapperToDomain
import com.mercado.pago.integration.core.data.service.MercadoPagoApiService
import com.mercado.pago.integration.core.domain.model.preferences.Preferences
import com.mercado.pago.integration.core.domain.model.subscription.Subscription
import com.mercado.pago.integration.core.domain.repository.MercadoPagoRepository
import javax.inject.Inject

class MercadoPagoRepositoryImpl @Inject constructor(
    private val service: MercadoPagoApiService,
    private val preferenceMapper: PreferenceResponseMapperToDomain,
    private val subscriptionMapper: SubscriptionResponseMapperToDomain
) : MercadoPagoRepository {

    override suspend fun createPreferences(): ApiState<Preferences> {
        return try {
            val response = service.createPreferences(MercadoPagoDataSource.BODY_PREFERENCES)
            val preferencesResponse =
                response ?: return ApiState.Error("Response is null")

            ApiState.Success(preferenceMapper.mapFrom(preferencesResponse))
        } catch (e: Exception) {
            ApiState.Error(e.message.toString())
        }
    }

    override suspend fun createSubscription(): ApiState<Subscription> {
        return try {
            val response = service.createSubscription(MercadoPagoDataSource.BODY_SUBSCRIPTION)
            val subscriptionResponse =
                response ?: return ApiState.Error("Response is null")

            ApiState.Success(subscriptionMapper.mapFrom(subscriptionResponse))
        } catch (e: Exception) {
            ApiState.Error(e.message.toString())
        }
    }
}
