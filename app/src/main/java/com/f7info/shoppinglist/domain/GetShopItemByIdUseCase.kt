package com.f7info.shoppinglist.domain

class GetShopItemByIdUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItemById(shopItemId:Int):ShopItem{
        return shopListRepository.getShopItemById(shopItemId)
    }
}