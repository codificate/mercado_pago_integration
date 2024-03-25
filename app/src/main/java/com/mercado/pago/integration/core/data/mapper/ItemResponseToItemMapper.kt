package com.mercado.pago.integration.core.data.mapper

import com.mercado.pago.integration.core.data.common.ListMapper
import com.mercado.pago.integration.core.data.model.response.components.ItemResponse
import com.mercado.pago.integration.core.domain.model.preferences.components.Item
import javax.inject.Inject

class ItemResponseToItemMapper @Inject constructor() :
    ListMapper<ItemResponse, Item> {
    override fun mapList(from: List<ItemResponse>): List<Item> {
        return from.map { mapItemResponseToItem(it) }
    }

    private fun mapItemResponseToItem(itemResponse: ItemResponse): Item {
        return itemResponse.let {
            Item(
                categoryId = it.categoryId,
                currencyId = it.currencyId,
                description = it.description,
                id = it.id,
                pictureUrl = it.pictureUrl,
                quantity = it.quantity,
                title = it.title,
                unitPrice = it.unitPrice
            )
        }
    }
}