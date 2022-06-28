package com.f7info.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun addShopItem( shopItem: ShopItem)
    fun getShopList():LiveData<List<ShopItem>>
    fun editShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun getShopItemById(shopItemId:Int):ShopItem
}