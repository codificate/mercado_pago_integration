package com.mercado.pago.integration

import androidx.annotation.StringRes

sealed class UIState {
    data object Init : UIState()
    data object Loading : UIState()
    data class Info<T>(val values: T) : UIState()
    data class Error(val message: String? = null, @StringRes val raw: Int? = null) : UIState()
}