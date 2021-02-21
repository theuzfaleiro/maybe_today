package dev.theuzfaleiro.maybetoday.ui.feature.home.repository

import dev.theuzfaleiro.maybetoday.database.dao.HomeDao
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category
import io.kotlintest.inspectors.forAll
import io.kotlintest.matchers.types.shouldBeInstanceOf
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import dev.theuzfaleiro.maybetoday.database.entity.Category as EntityCategory

class HomeRepositoryTest {
    private val homeDao: HomeDao = mockk()
    private lateinit var homeRepository: HomeRepository

    @Before
    fun setUp() {
        homeRepository = HomeRepository(homeDao)
    }

    @Test
    fun shouldReturnCategoryListWhenGetAllCategoriesFromDatabase() = runBlocking {
        coEvery {
            homeDao.getAllCategories()
        } returns listOf(
            EntityCategory(
                categoryId = 1L,
                categoryName = "Personal"
            ), EntityCategory(
                categoryId = 2L,
                categoryName = "Study"
            )
        )

        homeRepository.getAllCategories().forAll {
            it.shouldBeInstanceOf<Category>()
        }
    }
}