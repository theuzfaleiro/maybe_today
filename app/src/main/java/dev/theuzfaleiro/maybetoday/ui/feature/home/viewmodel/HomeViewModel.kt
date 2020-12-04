package dev.theuzfaleiro.maybetoday.ui.feature.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Task
import dev.theuzfaleiro.maybetoday.ui.feature.home.repository.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val taskMutableLiveData = MutableLiveData<List<Task>>()

    val taskLiveData: LiveData<List<Task>>
        get() = taskMutableLiveData

    fun getAllTasks() = viewModelScope.launch {
        taskMutableLiveData.postValue(homeRepository.getAllTasks())
    }
}