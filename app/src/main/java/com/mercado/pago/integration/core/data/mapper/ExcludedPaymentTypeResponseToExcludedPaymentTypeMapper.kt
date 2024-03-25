package com.mercado.pago.integration.core.data.mapper

import com.mercado.pago.integration.core.data.common.ListMapper
import com.mercado.pago.integration.core.data.model.response.components.ExcludedPaymentTypeResponse
import com.mercado.pago.integration.core.domain.model.preferences.components.ExcludedPaymentType
import javax.inject.Inject

class ExcludedPaymentTypeToExcludedPaymentTypeMapper @Inject constructor() :
    ListMapper<ExcludedPaymentTypeResponse, ExcludedPaymentType> {
    override fun mapList(from: List<ExcludedPaymentTypeResponse>): List<ExcludedPaymentType> {
        return from.map { mapExcludedPaymentTypeResponseToExcludedPaymentType(it) }
    }

    private fun mapExcludedPaymentTypeResponseToExcludedPaymentType(
        excludedPaymentTypeResponse: ExcludedPaymentTypeResponse
    ): ExcludedPaymentType {
        return ExcludedPaymentType(
            id = excludedPaymentTypeResponse.id
        )
    }
}