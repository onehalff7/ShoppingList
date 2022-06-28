package com.f7info.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.f7info.shoppinglist.data.ShopListRepositoryImpl
import com.f7info.shoppinglist.domain.*

class MainViewModel:ViewModel() {
    private val repository = ShopListRepositoryImpl
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)

    }
    fun changeEnableState(shopItem: ShopItem){
        val newItem = shopItem.copy(enable = !shopItem.enable)
        editShopItemUseCase.editShopItem(newItem)

    }
}