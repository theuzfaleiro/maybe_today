package dev.theuzfaleiro.maybetoday.ui.feature.home.repository

import dev.theuzfaleiro.maybetoday.database.dao.HomeDAO
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Task

class HomeRepository(private val homeDAO: HomeDAO) {

    suspend fun getAllTasks(): List<Task> {
        return homeDAO.getAllTasks().map {
            Task(it.id, it.taskTitle, it.taskDescription)
        }
    }
}