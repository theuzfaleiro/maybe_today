package dev.theuzfaleiro.maybetoday.ui.feature.task.repository

import dev.theuzfaleiro.maybetoday.database.dao.TaskDao
import dev.theuzfaleiro.maybetoday.database.entity.Task
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category

class TaskRepository(private val taskDao: TaskDao) {

    suspend fun insertNewTask(category: Long, title: String, description: String): Long =
        taskDao.insert(
            Task(
                categoryId = category,
                taskTitle = title,
                taskDescription = description
            )
        )

    suspend fun getAllCategories() = taskDao.getAllCategories().map { category ->
        Category(category.categoryId, category.categoryName)
    }
}
