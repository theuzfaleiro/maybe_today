package dev.theuzfaleiro.maybetoday.ui.feature.task.repository

import dev.theuzfaleiro.maybetoday.database.dao.TaskDAO
import dev.theuzfaleiro.maybetoday.database.entity.Task
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category

class TaskRepository(private val taskDAO: TaskDAO) {

    suspend fun insertNewTask(category: Long, title: String, description: String) =
        taskDAO.insertTask(
            Task(
                categoryId = category,
                taskTitle = title,
                taskDescription = description
            )
        )

    suspend fun getAllCategories() = taskDAO.getAllCategories().map { category ->
        Category(category.categoryId, category.categoryName)
    }
}