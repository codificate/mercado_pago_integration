package com.mercado.pago.integration.core.data.common

interface Mapper<F, T> {
    fun mapFrom(from: F): T
}