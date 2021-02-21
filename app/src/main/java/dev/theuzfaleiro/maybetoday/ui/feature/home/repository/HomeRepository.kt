package dev.theuzfaleiro.maybetoday.ui.feature.home.repository

import dev.theuzfaleiro.maybetoday.database.dao.HomeDao
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category

class HomeRepository(private val homeDao: HomeDao) {

    suspend fun getAllCategories(): List<Category> {
        return homeDao.getAllCategories().map {
            Category(it.categoryId, it.categoryName)
        }
    }
}