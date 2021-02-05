package dev.theuzfaleiro.maybetoday.ui.feature.home.repository

import dev.theuzfaleiro.maybetoday.database.dao.HomeDAO
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HomeRepository(private val homeDAO: HomeDAO) {

    fun getAllCategories(): Flow<List<Category>> {
        return homeDAO.getAllCategories().map {
            listOf(Category(it.id, it.name))
        }
    }
}