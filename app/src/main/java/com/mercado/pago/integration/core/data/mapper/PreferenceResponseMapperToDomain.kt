package com.mercado.pago.integration.core.data.mapper

import com.mercado.pago.integration.core.data.common.ListMapper
import com.mercado.pago.integration.core.data.common.Mapper
import com.mercado.pago.integration.core.data.model.response.PreferencesResponse
import com.mercado.pago.integration.core.data.model.response.components.ExcludedPaymentMethodResponse
import com.mercado.pago.integration.core.data.model.response.components.ExcludedPaymentTypeResponse
import com.mercado.pago.integration.core.data.model.response.components.ItemResponse
import com.mercado.pago.integration.core.domain.model.preferences.Preferences
import com.mercado.pago.integration.core.domain.model.preferences.components.Address
import com.mercado.pago.integration.core.domain.model.preferences.components.BackUrls
import com.mercado.pago.integration.core.domain.model.preferences.components.ExcludedPaymentMethod
import com.mercado.pago.integration.core.domain.model.preferences.components.ExcludedPaymentType
import com.mercado.pago.integration.core.domain.model.preferences.components.Identification
import com.mercado.pago.integration.core.domain.model.preferences.components.Item
import com.mercado.pago.integration.core.domain.model.preferences.components.Payer
import com.mercado.pago.integration.core.domain.model.preferences.components.PaymentMethods
import com.mercado.pago.integration.core.domain.model.preferences.components.Phone
import com.mercado.pago.integration.core.domain.model.preferences.components.ReceiverAddress
import com.mercado.pago.integration.core.domain.model.preferences.components.RedirectUrls
import com.mercado.pago.integration.core.domain.model.preferences.components.Shipments
import com.mercado.pago.integration.core.domain.model.preferences.components.Metadata
import javax.inject.Inject

class PreferenceResponseMapperToDomain @Inject constructor(
    private val itemResponseToItemMapper: ListMapper<ItemResponse, com.mercado.pago.integration.core.domain.model.preferences.components.Item>,
    private val excludedPaymentMethodsResponseToExcludedPaymentMethodsMapper: ListMapper<ExcludedPaymentMethodResponse, com.mercado.pago.integration.core.domain.model.preferences.components.ExcludedPaymentMethod>,
    private val excludedPaymentTypeResponseToExcludedPaymentType: ListMapper<ExcludedPaymentTypeResponse, com.mercado.pago.integration.core.domain.model.preferences.components.ExcludedPaymentType>
) : Mapper<PreferencesResponse, com.mercado.pago.integration.core.domain.model.preferences.Preferences> {
    override fun mapFrom(from: PreferencesResponse): com.mercado.pago.integration.core.domain.model.preferences.Preferences {
        return com.mercado.pago.integration.core.domain.model.preferences.Preferences(
            additionalInfo = from.additionalInfo,
            autoReturn = from.autoReturn,
            backUrls = com.mercado.pago.integration.core.domain.model.preferences.components.BackUrls(
                failure = from.backUrlsResponse?.failure,
                pending = from.backUrlsResponse?.pending,
                success = from.backUrlsResponse?.success
            ),
            binaryMode = from.binaryMode,
            clientId = from.clientId,
            collectorId = from.collectorId,
            couponCode = from.couponCode,
            couponLabels = from.couponLabels,
            dateCreated = from.dateCreated,
            dateOfExpiration = from.dateOfExpiration,
            expirationDateFrom = from.expirationDateFrom,
            expirationDateTo = from.expirationDateTo,
            expires = from.expires,
            externalReference = from.externalReference,
            id = from.id,
            initPoint = from.initPoint,
            internalMetadata = from.internalMetadata,
            items = itemResponseToItemMapper.mapList(from.itemResponses),
            lastUpdated = from.lastUpdated,
            marketplace = from.marketplace,
            marketplaceFee = from.marketplaceFee,
            metadata = com.mercado.pago.integration.core.domain.model.preferences.components.Metadata(
                from.metadataResponse?.data
            ),
            notificationUrl = from.notificationUrl,
            operationType = from.operationType,
            payerResponse = com.mercado.pago.integration.core.domain.model.preferences.components.Payer(
                address = com.mercado.pago.integration.core.domain.model.preferences.components.Address(
                    streetName = from.payerResponse?.addressResponse?.streetName,
                    streetNumber = from.payerResponse?.addressResponse?.streetNumber,
                    zipCode = from.payerResponse?.addressResponse?.zipCode
                ),
                dateCreated = from.payerResponse?.dateCreated,
                email = from.payerResponse?.email,
                identification = com.mercado.pago.integration.core.domain.model.preferences.components.Identification(
                    number = from.payerResponse?.identificationResponse?.number,
                    type = from.payerResponse?.identificationResponse?.type
                ),
                lastPurchase = from.payerResponse?.lastPurchase,
                name = from.payerResponse?.name,
                phone = com.mercado.pago.integration.core.domain.model.preferences.components.Phone(
                    areaCode = from.payerResponse?.phoneResponse?.areaCode,
                    number = from.payerResponse?.phoneResponse?.number
                ),
                surname = from.payerResponse?.surname,
            ),
            paymentMethods = com.mercado.pago.integration.core.domain.model.preferences.components.PaymentMethods(
                defaultCardId = from.paymentMethodsResponse?.defaultCardId,
                defaultInstallments = from.paymentMethodsResponse?.defaultInstallments,
                defaultPaymentMethodId = from.paymentMethodsResponse?.defaultPaymentMethodId,
                excludedPaymentMethods = from.paymentMethodsResponse?.let { it ->
                    excludedPaymentMethodsResponseToExcludedPaymentMethodsMapper.mapList(
                        it.excludedPaymentMethodResponses
                    )
                },
                excludedPaymentTypes = from.paymentMethodsResponse?.let {
                    excludedPaymentTypeResponseToExcludedPaymentType.mapList(it.excludedPaymentTypeResponses)
                },
                installments = from.paymentMethodsResponse?.installments
            ),
            processingModes = from.processingModes,
            productId = from.productId,
            redirectUrls = com.mercado.pago.integration.core.domain.model.preferences.components.RedirectUrls(
                failure = from.redirectUrlsResponse?.failure,
                pending = from.redirectUrlsResponse?.pending,
                success = from.redirectUrlsResponse?.success
            ),
            sandboxInitPoint = from.sandboxInitPointResponse,
            shipments = com.mercado.pago.integration.core.domain.model.preferences.components.Shipments(
                defaultShippingMethod = from.shipmentsResponse?.defaultShippingMethod,
                receiverAddress = com.mercado.pago.integration.core.domain.model.preferences.components.ReceiverAddress(
                    apartment = from.shipmentsResponse?.receiverAddressResponse?.apartment,
                    cityName = from.shipmentsResponse?.receiverAddressResponse?.cityName,
                    countryName = from.shipmentsResponse?.receiverAddressResponse?.countryName,
                    floor = from.shipmentsResponse?.receiverAddressResponse?.floor,
                    stateName = from.shipmentsResponse?.receiverAddressResponse?.stateName,
                    streetName = from.shipmentsResponse?.receiverAddressResponse?.streetName,
                    streetNumber = from.shipmentsResponse?.receiverAddressResponse?.streetNumber,
                    zipCode = from.shipmentsResponse?.receiverAddressResponse?.zipCode
                )
            ),
            siteId = from.siteIdResponse,
            totalAmount = from.totalAmountResponse
        )
    }
}