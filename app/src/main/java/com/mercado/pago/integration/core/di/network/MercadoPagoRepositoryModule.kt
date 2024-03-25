package com.mercado.pago.integration.core.di.network

import com.mercado.pago.integration.core.data.common.ListMapper
import com.mercado.pago.integration.core.data.common.Mapper
import com.mercado.pago.integration.core.data.mapper.ExcludePaymentMethodsResponseToExcludedPaymentMethodsMapper
import com.mercado.pago.integration.core.data.mapper.ExcludedPaymentTypeToExcludedPaymentTypeMapper
import com.mercado.pago.integration.core.data.mapper.ItemResponseToItemMapper
import com.mercado.pago.integration.core.data.mapper.PreferenceResponseMapperToDomain
import com.mercado.pago.integration.core.data.mapper.SubscriptionResponseMapperToDomain
import com.mercado.pago.integration.core.data.model.response.PreferencesResponse
import com.mercado.pago.integration.core.data.model.response.SubscriptionResponse
import com.mercado.pago.integration.core.data.model.response.components.ExcludedPaymentMethodResponse
import com.mercado.pago.integration.core.data.model.response.components.ExcludedPaymentTypeResponse
import com.mercado.pago.integration.core.data.model.response.components.ItemResponse
import com.mercado.pago.integration.core.data.repository.MercadoPagoRepositoryImpl
import com.mercado.pago.integration.core.data.service.MercadoPagoApiService
import com.mercado.pago.integration.core.domain.model.preferences.Preferences
import com.mercado.pago.integration.core.domain.model.preferences.components.ExcludedPaymentMethod
import com.mercado.pago.integration.core.domain.model.preferences.components.ExcludedPaymentType
import com.mercado.pago.integration.core.domain.model.preferences.components.Item
import com.mercado.pago.integration.core.domain.model.subscription.Subscription
import com.mercado.pago.integration.core.domain.repository.MercadoPagoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MercadoPagoRepositoryModule {

    @Provides
    @Singleton
    fun provideItemResponseToItemMapper(): ListMapper<ItemResponse, Item> {
        return ItemResponseToItemMapper()
    }

    @Provides
    @Singleton
    fun provideExcludePaymentMethodsResponseToExcludedPaymentMethodsMapper(): ListMapper<ExcludedPaymentMethodResponse, ExcludedPaymentMethod> {
        return ExcludePaymentMethodsResponseToExcludedPaymentMethodsMapper()
    }

    @Provides
    @Singleton
    fun provideExcludedPaymentTypeToExcludedPaymentTypeMapper(): ListMapper<ExcludedPaymentTypeResponse, ExcludedPaymentType> {
        return ExcludedPaymentTypeToExcludedPaymentTypeMapper()
    }

    @Provides
    @Singleton
    fun providePreferenceResponseMapperToDomainMapper(
        itemResponseToItemMapper: ItemResponseToItemMapper,
        excludedPaymentMethodsResponseToExcludedPaymentMethodMapper: ExcludePaymentMethodsResponseToExcludedPaymentMethodsMapper,
        excludedPaymentTypeResponseToExcludedPaymentTypeMapper: ExcludedPaymentTypeToExcludedPaymentTypeMapper
    ): Mapper<PreferencesResponse, Preferences> {
        return PreferenceResponseMapperToDomain(
            itemResponseToItemMapper,
            excludedPaymentMethodsResponseToExcludedPaymentMethodMapper,
            excludedPaymentTypeResponseToExcludedPaymentTypeMapper
        )
    }

    @Provides
    @Singleton
    fun provideSubscriptionResponseMapperToDomain(): Mapper<SubscriptionResponse, Subscription> {
        return SubscriptionResponseMapperToDomain()
    }

    @Provides
    @Singleton
    fun providesMercadoPagoRepository(
        service: MercadoPagoApiService,
        preferenceMapper: PreferenceResponseMapperToDomain,
        subscriptionMapper: SubscriptionResponseMapperToDomain
    ): MercadoPagoRepository =
        MercadoPagoRepositoryImpl(service, preferenceMapper, subscriptionMapper)
}