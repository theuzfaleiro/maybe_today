package dev.theuzfaleiro.maybetoday.ui.feature.home.repository

import dev.theuzfaleiro.maybetoday.database.dao.HomeDAO
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category

class HomeRepository(private val homeDAO: HomeDAO) {

    suspend fun getAllCategories(): List<Category> {
        return homeDAO.getAllCategories().map {
            Category(it.id, it.name)
        }
    }
}