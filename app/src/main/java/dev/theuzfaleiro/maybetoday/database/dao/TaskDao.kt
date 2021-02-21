package dev.theuzfaleiro.maybetoday.database.dao

import androidx.room.*
import dev.theuzfaleiro.maybetoday.database.entity.Category
import dev.theuzfaleiro.maybetoday.database.entity.Task

@Dao
interface TaskDao : BaseDao<Task> {

    @Query("SELECT * FROM CATEGORY")
    suspend fun getAllCategories(): List<Category>
}