package dev.theuzfaleiro.maybetoday.ui.feature.home.viewmodel

import androidx.lifecycle.*
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category
import dev.theuzfaleiro.maybetoday.ui.feature.home.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val categoriesMutableLiveData: LiveData<List<Category>> =
        getAllCategories().asLiveData()

    val categoriesLiveData: LiveData<List<Category>>
        get() = categoriesMutableLiveData

    fun getAllCategories() = flow {
        homeRepository.getAllCategories().collect {
            emit(it)
        }
    }
}