package com.mercado.pago.integration.core.di.network

import com.mercado.pago.integration.BuildConfig
import com.mercado.pago.integration.core.data.service.MercadoPagoApiClient
import com.mercado.pago.integration.core.data.service.MercadoPagoApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkingApiModule {

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor(Interceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer ${BuildConfig.API_KEY}")
                    .header("Content-Type", "application/json")
                    .build()
                chain.proceed(request)
            })
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun providesMercadoPagoApiClient(retrofit: Retrofit): MercadoPagoApiClient =
        retrofit.create(MercadoPagoApiClient::class.java)

    @Provides
    @Singleton
    fun providesMercadoPagoApiService(apiService: MercadoPagoApiClient): MercadoPagoApiService =
        MercadoPagoApiService(apiService)
}