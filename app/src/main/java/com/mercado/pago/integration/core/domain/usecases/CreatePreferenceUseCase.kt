package com.mercado.pago.integration.core.domain.usecases

import com.mercado.pago.integration.core.data.common.ApiState
import com.mercado.pago.integration.core.domain.model.preferences.Preferences
import com.mercado.pago.integration.core.domain.repository.MercadoPagoRepository
import javax.inject.Inject

class CreatePreferenceUseCase @Inject constructor(private val mercadoPagoRepository: MercadoPagoRepository) {
    suspend operator fun invoke(): ApiState<Preferences> {
        return mercadoPagoRepository.createPreferences()
    }
}