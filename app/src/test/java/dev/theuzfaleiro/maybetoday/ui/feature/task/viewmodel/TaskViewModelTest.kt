package dev.theuzfaleiro.maybetoday.ui.feature.task.viewmodel

import dev.theuzfaleiro.maybetoday.ui.feature.task.repository.TaskRepository
import io.kotlintest.matchers.types.shouldBeInstanceOf
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class TaskViewModelTest {

    private val taskRepository = mockk<TaskRepository>(relaxed = true)

    private lateinit var taskViewModel: TaskViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.IO)

        taskViewModel = TaskViewModel(taskRepository)
    }

    @Test
    fun getTaskLiveData() = runBlocking {
        coEvery {
            taskRepository.insertNewTask(any(), any())
        } returns Long.MIN_VALUE

        taskViewModel.createNewTask("any()", "any()")

        taskViewModel.taskLiveData.value.shouldBeInstanceOf<TaskViewModel.TaskState.Inserted>()
    }

    @Test
    fun addTask() {
    }

    @After
    fun tearDown() {

    }
}
