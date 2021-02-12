package dev.theuzfaleiro.maybetoday.ui.feature.home.viewmodel

import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category
import dev.theuzfaleiro.maybetoday.ui.feature.home.repository.HomeRepository
import dev.theuzfaleiro.maybetoday.ui.feature.util.rule.CoroutinesTestRule
import io.kotlintest.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val testCoroutineRule = CoroutinesTestRule()

    private lateinit var homeViewModel: HomeViewModel

    private val homeRepository: HomeRepository = mockk()

    @Before
    fun setUp() {
        homeViewModel = HomeViewModel(homeRepository)
    }

    @Test
    fun myNewNewbieTest() = runBlocking {
        val categoryFlow = flow {
            emit(listOf(Category(id = 0, "Personal")))
        }

        every {
            homeRepository.getAllCategories()
        } returns categoryFlow

        homeViewModel.getAllCategories().collect {
            it.first().name shouldBe "Personal"
        }
    }
}