package dev.theuzfaleiro.maybetoday.ui.feature.task.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Task
import dev.theuzfaleiro.maybetoday.ui.feature.task.repository.TaskRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class TaskViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    val categoriesLiveData: LiveData<List<Category>> = loadAllCategories().asLiveData()

    fun createNewTask(taskToBeCreated: Task) = viewModelScope.launch {
        taskRepository.insertNewTask(
            taskToBeCreated.categoryId,
            taskToBeCreated.taskTitle,
            taskToBeCreated.taskDescription
        )
    }

    private fun loadAllCategories() = flow {
        emit(taskRepository.getAllCategories())
    }
}
