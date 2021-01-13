package dev.theuzfaleiro.maybetoday.ui.feature.home.repository

import dev.theuzfaleiro.maybetoday.database.dao.HomeDAO
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Task

class HomeRepository(private val homeDAO: HomeDAO) {

    suspend fun getAllCategories(): List<Category> {
        return homeDAO.getAllTasks().map {
            Category(it.id, it.taskTitle, it.taskDescription)
        }
    }
}