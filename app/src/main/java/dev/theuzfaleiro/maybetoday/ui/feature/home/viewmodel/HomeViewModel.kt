package dev.theuzfaleiro.maybetoday.ui.feature.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category
import dev.theuzfaleiro.maybetoday.ui.feature.home.repository.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val categoryMutableLiveData = MutableLiveData<List<Category>>()

    val categoryLiveData: LiveData<List<Category>>
        get() = categoryMutableLiveData

    fun getAllCategories() = viewModelScope.launch {
        categoryMutableLiveData.postValue(homeRepository.getAllCategories())
    }
}