package com.f7info.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.f7info.shoppinglist.domain.ShopItem
import com.f7info.shoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {
    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0
    init {
        for(i in 0 until 10){
            val item = ShopItem("Name $i",i,true)
            addShopItem(item)
        }

    }
    override fun addShopItem(shopItem: ShopItem) {
        if(shopItem.id ==ShopItem.UNDEFINED_ID) shopItem.id = autoIncrementId
        shopList.add(shopItem)
        updateList()
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    override fun editShopItem(shopItem: ShopItem) {
       val oldElement = getShopItemById(shopItem.id)
        deleteShopItem(oldElement)
        addShopItem(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun getShopItemById(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("element with id: $shopItemId not found")
    }
    private fun updateList(){
        shopListLD.value = shopList.toList()
    }
}