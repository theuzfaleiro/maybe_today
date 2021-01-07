package dev.theuzfaleiro.maybetoday.ui.feature.home.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Task
import dev.theuzfaleiro.maybetoday.ui.feature.home.repository.HomeRepository
import dev.theuzfaleiro.maybetoday.ui.feature.util.rule.CoroutinesTestRule
import io.kotlintest.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = CoroutinesTestRule()

    private lateinit var homeViewModel: HomeViewModel

    private val homeRepository: HomeRepository = mockk()

    @Before
    fun setUp() {
        homeViewModel = HomeViewModel(homeRepository)
    }

    @Test
    fun myNewNewbieTest() {
        coEvery {
            homeRepository.getAllTasks()
        } returns listOf(Task(0, "Random Title", "Random Long Description"))

        homeViewModel.getAllTasks()

        homeViewModel.taskLiveData.value!!.first().taskTitle shouldBe "Random Title"
    }
}