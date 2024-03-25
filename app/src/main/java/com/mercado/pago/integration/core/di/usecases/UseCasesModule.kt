package com.mercado.pago.integration.core.di.usecases

import com.mercado.pago.integration.core.domain.repository.MercadoPagoRepository
import com.mercado.pago.integration.core.domain.usecases.CreatePreferenceUseCase
import com.mercado.pago.integration.core.domain.usecases.CreateSubscriptionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    @Singleton
    fun providesCreatesPreferenceUseCase(repository: MercadoPagoRepository) =
        CreatePreferenceUseCase(repository)

    @Provides
    @Singleton
    fun providesCreatesSubscriptionUseCase(repository: MercadoPagoRepository) =
        CreateSubscriptionUseCase(repository)
}