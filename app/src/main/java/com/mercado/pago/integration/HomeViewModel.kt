package com.mercado.pago.integration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mercado.pago.integration.core.data.common.ApiState
import com.mercado.pago.integration.core.domain.usecases.CreatePreferenceUseCase
import com.mercado.pago.integration.core.domain.usecases.CreateSubscriptionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val createPreferenceUseCase: CreatePreferenceUseCase,
    private val createSubscriptionUseCase: CreateSubscriptionUseCase
) : ViewModel() {

    private val mutableState = MutableStateFlow(MercadoPagoStateProvider.initProvider())
    val state: StateFlow<MercadoPagoStateProvider> = mutableState
    fun createPreferences() {
        //mutableState.value = UIState.Loading
        viewModelScope.launch {
            when (val result = createPreferenceUseCase()) {
                is ApiState.Error -> Unit
                is ApiState.Success -> {
                    mutableState
                        .filterNotNull()
                        .onEach { stateProvider ->
                            stateProvider.updatePreferences(result.data)
                            mutableState.emit(stateProvider)
                        }
                        .launchIn(this)
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
                    mutableState
                        .filterNotNull()
                        .onEach { stateProvider ->
                            stateProvider.updateSubscription(result.data)
                            mutableState.emit(stateProvider)
                        }
                        .launchIn(this)
                }
            }
        }
    }
}