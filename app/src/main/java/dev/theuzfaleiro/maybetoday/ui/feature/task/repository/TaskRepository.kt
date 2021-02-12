package dev.theuzfaleiro.maybetoday.ui.feature.task.repository

import dev.theuzfaleiro.maybetoday.database.dao.TaskDAO
import dev.theuzfaleiro.maybetoday.database.entity.Task
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category

class TaskRepository(private val taskDAO: TaskDAO) {

    suspend fun insertNewTask(title: String, description: String): Long {
        return taskDAO.insertTask(
            Task(
                categoryId = 0,
                taskTitle = title,
                taskDescription = description
            )
        )
    }

    suspend fun getAllCategories(): List<Category> {
        return taskDAO.getAllCategories().map { category ->
            Category(category.categoryId, category.categoryName)
        }
    }
}