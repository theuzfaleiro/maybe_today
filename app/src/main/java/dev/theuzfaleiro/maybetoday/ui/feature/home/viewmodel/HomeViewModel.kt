package dev.theuzfaleiro.maybetoday.ui.feature.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category
import dev.theuzfaleiro.maybetoday.ui.feature.home.repository.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val categoriesWithTask = MutableLiveData<States>()

    fun getAllCategoriesWithTask(): LiveData<States> {
        return categoriesWithTask
    }

    fun loadAllCategoriesWithTask() = viewModelScope.launch {
        try {
            if (homeRepository.getAllCategories().isNotEmpty()) {
                categoriesWithTask.postValue(States.Success(homeRepository.getAllCategories()))
            } else {
                categoriesWithTask.postValue(States.Error)
            }
        } catch (exception: Exception) {
            categoriesWithTask.postValue(States.Error)
        }
    }
}

sealed class States {
    class Success(val category: List<Category>) : States()

    object Loading : States()

    object Error : States()
}