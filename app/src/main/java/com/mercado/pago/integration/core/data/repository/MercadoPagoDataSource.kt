package com.mercado.pago.integration.core.data.repository

import com.mercado.pago.integration.core.data.model.request.PreferencesRequest
import com.mercado.pago.integration.core.data.model.request.components.BackUrlsRequest
import com.mercado.pago.integration.core.data.model.request.components.ItemRequest
import com.mercado.pago.integration.core.data.model.request.SubscriptionRequest
import com.mercado.pago.integration.core.data.model.request.components.AddressRequest
import com.mercado.pago.integration.core.data.model.request.components.AutoRecurringRequest
import com.mercado.pago.integration.core.data.model.request.components.IdentificationRequest
import com.mercado.pago.integration.core.data.model.request.components.PayerRequest
import com.mercado.pago.integration.core.data.model.request.components.PhoneRequest

class MercadoPagoDataSource {

    companion object {
        val BODY_PREFERENCES = PreferencesRequest(
            payer = PayerRequest(
                address = AddressRequest("conde", "1428", 2850),
                identification = IdentificationRequest("DNI", "12234345"),
                phone = PhoneRequest("+54", "1112233445"),
                name = "Usuario MakiTEST",
                email = "usuario@makitest.com"
            ), //Your buyer user
            itemRequests = listOf(
                ItemRequest(
                    titleRequest = "Learnings",
                    descriptionRequest = "A learning item",
                    pictureUrlRequest = "http://www.myapp.com/myimage.jpg",
                    categoryIdRequest = "learnings",
                    quantityRequest = 1,
                    currencyIdRequest = "ARS",
                    unitPriceRequest = 3
                )
            ),
            backUrlsRequest = BackUrlsRequest(
                failureRequest = "app://home",
                pendingRequest = "app://home",
                successRequest = "app://home"
            ),
            autoReturn = "approved"
        )

        val BODY_SUBSCRIPTION = SubscriptionRequest(
            autoRecurringRequest = AutoRecurringRequest(
                currencyIdRequest = "ARS",
                frequencyRequest = 1,
                frequencyTypeRequest = "months",
                transactionAmountRequest = 5
            ),
            backUrlRequest = "https://mercadopago.com.ar",
            payerEmailRequest = "", //Your buyer user
            reasonRequest = "Learning subscription"
        )
    }
}
