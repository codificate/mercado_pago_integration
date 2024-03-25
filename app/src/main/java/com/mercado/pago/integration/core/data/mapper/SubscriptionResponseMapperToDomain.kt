package com.mercado.pago.integration.core.data.mapper

import com.mercado.pago.integration.core.data.common.Mapper
import com.mercado.pago.integration.core.data.model.response.SubscriptionResponse
import com.mercado.pago.integration.core.domain.model.subscription.Subscription
import com.mercado.pago.integration.core.domain.model.subscription.components.AutoRecurring
import javax.inject.Inject


class SubscriptionResponseMapperToDomain @Inject constructor() :
    Mapper<SubscriptionResponse, Subscription> {
    override fun mapFrom(from: SubscriptionResponse): Subscription {
        return Subscription(
            applicationId = from.applicationIdResponse,
            autoRecurring = AutoRecurring(
                currencyId = from.autoRecurringResponse.currencyIdResponse,
                freeTrial = from.autoRecurringResponse.freeTrialResponse,
                frequency = from.autoRecurringResponse.frequencyResponse,
                frequencyType = from.autoRecurringResponse.frequencyTypeResponse,
                transactionAmount = from.autoRecurringResponse.transactionAmountResponse
            ),
            backUrl = from.backUrlResponse,
            collectorId = from.collectorIdResponse,
            dateCreated = from.dateCreatedResponse,
            firstInvoiceOffset = from.firstInvoiceOffsetResponse,
            id = from.idResponse,
            initPoint = from.initPointResponse,
            lastModified = from.lastModifiedResponse,
            payerEmail = from.payerEmailResponse,
            payerId = from.payerIdResponse,
            paymentMethodId = from.paymentMethodIdResponse,
            reason = from.reasonResponse,
            status = from.statusResponse,
            summarized = com.mercado.pago.integration.core.domain.model.subscription.components.Summarized(
                chargedAmount = from.summarizedResponse.chargedAmount,
                chargedQuantity = from.summarizedResponse.chargedQuantity,
                lastChargedAmount = from.summarizedResponse.lastChargedAmount,
                lastChargedDate = from.summarizedResponse.lastChargedDate,
                pendingChargeAmount = from.summarizedResponse.pendingChargeAmount,
                pendingChargeQuantity = from.summarizedResponse.pendingChargeQuantity,
                quotas = from.summarizedResponse.quotas,
                semaphore = from.summarizedResponse.semaphore
            )
        )
    }
}