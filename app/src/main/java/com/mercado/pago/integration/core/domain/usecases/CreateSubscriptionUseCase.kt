package com.mercado.pago.integration.core.domain.usecases

import com.mercado.pago.integration.core.data.common.ApiState
import com.mercado.pago.integration.core.domain.model.subscription.Subscription
import com.mercado.pago.integration.core.domain.repository.MercadoPagoRepository
import javax.inject.Inject

class CreateSubscriptionUseCase @Inject constructor(private val mercadoPagoRepository: MercadoPagoRepository) {
    suspend operator fun invoke(): ApiState<Subscription> {
        return mercadoPagoRepository.createSubscription()
    }
}