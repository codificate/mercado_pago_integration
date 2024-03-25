package com.mercado.pago.integration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mercado.pago.integration.core.data.common.ApiState
import com.mercado.pago.integration.core.domain.model.preferences.Preferences
import com.mercado.pago.integration.core.domain.model.subscription.Subscription
import com.mercado.pago.integration.core.domain.usecases.CreatePreferenceUseCase
import com.mercado.pago.integration.core.domain.usecases.CreateSubscriptionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val createPreferenceUseCase: CreatePreferenceUseCase,
    private val createSubscriptionUseCase: CreateSubscriptionUseCase
) : ViewModel() {

    private val mutablePreferencesState = MutableStateFlow<Preferences?>(null)
    val preferencesState: StateFlow<Preferences?> = mutablePreferencesState

    private val mutableSubscriptionState = MutableStateFlow<Subscription?>(null)
    val subscriptionState: StateFlow<Subscription?> = mutableSubscriptionState
    fun createPreferences() {
        //mutableState.value = UIState.Loading
        viewModelScope.launch {
            when (val result = createPreferenceUseCase()) {
                is ApiState.Error -> Unit
                is ApiState.Success -> {
                    mutablePreferencesState.emit(result.data)
                }
            }
        }
    }

    fun createSubscription() {
        //mutableState.value = UIState.Loading
        viewModelScope.launch {
            when (val result = createSubscriptionUseCase()) {
                is ApiState.Error -> Unit
                is ApiState.Success -> {
                    mutableSubscriptionState.emit(result.data)
                }
            }
        }
    }
}