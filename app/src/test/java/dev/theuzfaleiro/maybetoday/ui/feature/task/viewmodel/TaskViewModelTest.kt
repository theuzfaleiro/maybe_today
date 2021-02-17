package dev.theuzfaleiro.maybetoday.ui.feature.task.viewmodel

import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Task
import dev.theuzfaleiro.maybetoday.ui.feature.task.repository.TaskRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

class TaskViewModelTest {

    private val taskRepository = mockk<TaskRepository>(relaxed = true)

    private lateinit var taskViewModel: TaskViewModel

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.IO)

        taskViewModel = TaskViewModel(taskRepository)
    }

    @Test
    fun getTaskLiveData(): Unit = runBlocking {
        coEvery {
            taskRepository.insertNewTask(any(), any(), any())
        } returns Long.MIN_VALUE

        taskViewModel.createNewTask(
            Task(
                id = 0,
                categoryId = 0,
                "Finish Maybe Today App",
                dueDate = "28/01/2021",
                taskDescription = "Add Unit Tests To All Features"
            )
        )

        //taskViewModel.taskLiveData.value.shouldBeInstanceOf<TaskViewModel.TaskState.Error>()
    }
}
