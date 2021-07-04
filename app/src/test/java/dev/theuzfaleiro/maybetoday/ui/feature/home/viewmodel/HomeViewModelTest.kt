package dev.theuzfaleiro.maybetoday.ui.feature.home.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category
import dev.theuzfaleiro.maybetoday.ui.feature.home.repository.HomeRepository
import dev.theuzfaleiro.maybetoday.ui.feature.util.rule.CoroutinesTestRule
import io.kotlintest.matchers.types.shouldBeTypeOf
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = CoroutinesTestRule()

    private lateinit var homeViewModel: HomeViewModel

    private val homeRepository: HomeRepository = mockk()

    @Before
    fun setUp() {
        homeViewModel = HomeViewModel(homeRepository)
    }

    @Test
    fun shouldReturnAllCategoriesWithTaskWhenLoaded() = runBlockingTest {
        coEvery {
            homeRepository.getAllCategories()
        } returns listOf(Category(0L, "Personal"))

        homeViewModel.loadAllCategoriesWithTask()

        homeViewModel.getAllCategoriesWithTask().value.shouldBeTypeOf<States.Success>()
    }

    @Test
    fun shouldNotShowCategoriesTaskWhenNoCategoryWasLoaded() = runBlockingTest {
        coEvery {
            homeRepository.getAllCategories()
        } returns listOf()

        homeViewModel.loadAllCategoriesWithTask()

        homeViewModel.getAllCategoriesWithTask().value.shouldBeTypeOf<States.Error>()
    }
}
