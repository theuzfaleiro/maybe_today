package dev.theuzfaleiro.maybetoday.ui.feature.task.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.theuzfaleiro.maybetoday.ui.feature.task.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    private val taskMutableLiveData = MutableLiveData<TaskState>()
    val taskLiveData: LiveData<TaskState>
        get() = taskMutableLiveData

    fun addTask(taskTitle: String, taskDescription: String) = viewModelScope.launch {
        try {
            if (taskRepository.insertNewTask(taskTitle, taskDescription) > 0) {
                taskMutableLiveData.postValue(TaskState.Inserted)
            }
        } catch (exception: Exception) {
            taskMutableLiveData.postValue(TaskState.Error)
        }
    }

    sealed class TaskState {
        object Inserted : TaskState()
        object Error : TaskState()
    }
}