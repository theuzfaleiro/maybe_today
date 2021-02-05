package dev.theuzfaleiro.maybetoday.ui.feature.task.viewmodel

import androidx.lifecycle.*
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Task
import dev.theuzfaleiro.maybetoday.ui.feature.task.repository.TaskRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class TaskViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    private val taskMutableLiveData = MutableLiveData<TaskState>()
    val taskLiveData: LiveData<TaskState>
        get() = taskMutableLiveData

    val categoriesLiveData: LiveData<List<Category>> = loadAllCategories().asLiveData()

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

    private fun loadAllCategories() = flow {
        emit(taskRepository.getAllCategories())
    }

    sealed class TaskState {
        object Inserted : TaskState()
        object Error : TaskState()
    }
}