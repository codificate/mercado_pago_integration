package com.mercado.pago.integration.core.data.common

interface ListMapper<F, T> {
    fun mapList(from: List<F>): List<T>
}