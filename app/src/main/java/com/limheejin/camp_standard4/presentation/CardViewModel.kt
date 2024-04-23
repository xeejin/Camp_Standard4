package com.limheejin.camp_standard4.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.limheejin.camp_standard4.data.CardData
import com.limheejin.camp_standard4.data.DataSource

class CardViewModel(val dataSource: DataSource) : ViewModel() {
    val cardsLiveData = dataSource.getCardList()

    fun getCardForId(id : Long) : CardData {
        return cardsLiveData.get(id.toInt())
    }
}

class CardViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CardViewModel::class.java)){
            return CardViewModel(dataSource = DataSource.getDataSource()) as T
        }
        throw IllegalAccessException("Unknown ViewModel Class")
    }
}