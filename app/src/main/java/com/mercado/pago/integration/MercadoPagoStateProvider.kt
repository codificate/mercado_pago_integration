package com.mercado.pago.integration

import com.mercado.pago.integration.core.domain.model.preferences.Preferences
import com.mercado.pago.integration.core.domain.model.subscription.Subscription

class MercadoPagoStateProvider(
    private var preferences: Preferences? = null,
    private var subscription: Subscription? = null
) {

    fun updatePreferences(newPreferences: Preferences) {
        preferences = newPreferences
    }

    fun updateSubscription(newSubscription: Subscription) {
        subscription = newSubscription
    }

    fun getPreferences() = preferences

    fun getSubscription() = subscription

    companion object {
        fun initProvider() = MercadoPagoStateProvider()
    }
}