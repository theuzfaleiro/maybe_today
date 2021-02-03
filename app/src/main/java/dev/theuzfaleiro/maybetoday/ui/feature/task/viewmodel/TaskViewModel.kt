package dev.theuzfaleiro.maybetoday.ui.feature.task.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Task
import dev.theuzfaleiro.maybetoday.ui.feature.task.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    private val taskMutableLiveData = MutableLiveData<TaskState>()
    val taskLiveData: LiveData<TaskState>
        get() = taskMutableLiveData

    private val categoriesMutableLiveData = MutableLiveData<Category>()
    val category: LiveData<Category>
        get() = categoriesMutableLiveData

    fun createNewTask(taskToBeCreated: Task) = viewModelScope.launch {
        try {
            if (taskRepository.insertNewTask(
                    taskToBeCreated.taskTitle,
                    taskToBeCreated.taskDescription
                ) > 0
            ) {
                taskMutableLiveData.postValue(TaskState.Inserted)
            }
        } catch (exception: Exception) {
            taskMutableLiveData.postValue(TaskState.Error)
        }
    }

    fun loadAllCategories() = viewModelScope.launch {
        categoriesMutableLiveData.postValue(taskRepository.getAllCategories())
    }

    sealed class TaskState {
        object Inserted : TaskState()
        object Error : TaskState()
    }
}