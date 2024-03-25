package com.mercado.pago.integration.core.data.mapper

import com.mercado.pago.integration.core.data.common.ListMapper
import com.mercado.pago.integration.core.data.model.response.components.ExcludedPaymentMethodResponse
import com.mercado.pago.integration.core.domain.model.preferences.components.ExcludedPaymentMethod
import javax.inject.Inject

class ExcludePaymentMethodsResponseToExcludedPaymentMethodsMapper @Inject constructor() :
    ListMapper<ExcludedPaymentMethodResponse, ExcludedPaymentMethod> {
    override fun mapList(from: List<ExcludedPaymentMethodResponse>): List<ExcludedPaymentMethod> {
        return from.map { mapExcludedPaymentMethodResponseToExcludedPaymentMethod(it) }
    }

    private fun mapExcludedPaymentMethodResponseToExcludedPaymentMethod(
        excludedPaymentMethodResponse: ExcludedPaymentMethodResponse
    ): ExcludedPaymentMethod {
        return ExcludedPaymentMethod(
            id = excludedPaymentMethodResponse.id
        )
    }
}