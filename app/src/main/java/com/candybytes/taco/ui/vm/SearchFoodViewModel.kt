package com.candybytes.taco.ui.vm

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.candybytes.taco.db.FoodDao
import com.candybytes.taco.ui.util.FoodAdapter
import timber.log.Timber

class SearchFoodViewModel @ViewModelInject constructor(
    private val foodDao: FoodDao,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val info = liveData {
        try {
            val foods = foodDao.getAllAsync()
            emit(foods)
        } catch (e: Exception) {
            Timber.e(e)
        }
    }.map { "Loaded ${it.size} foods" }

    var searchText = MutableLiveData("")
    // var searchText = MutableLiveData("Bol")

    var adapter = MutableLiveData(FoodAdapter())

    var foodList = liveData {
        try {
            if (searchText.value!!.isEmpty()) {
                emit(foodDao.getAllAsync())
            } else {
                emit(foodDao.getSearchResult(searchText.value!! + "%"))
            }
        } catch (e: Exception) {
            Timber.e(e)
        }
    }.map { it }

    /*var queryTextChangedJob: Job? = null
    val searchResult: () -> Unit = {
        queryTextChangedJob?.cancel()
        queryTextChangedJob = viewModelScope.launch(Dispatchers.Main) {
            delay(500)
            foodList = liveData {
                try {
                    emit(foodDao.getSearchResult(searchText.value!!))
                } catch (e: Exception) {
                    Timber.e(e)
                }
            }.map { it }
        }
    }*/
}
