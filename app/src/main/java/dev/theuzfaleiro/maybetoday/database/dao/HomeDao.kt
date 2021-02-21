package dev.theuzfaleiro.maybetoday.database.dao

import androidx.room.*
import dev.theuzfaleiro.maybetoday.database.entity.Category
import dev.theuzfaleiro.maybetoday.database.relations.CategoriesWithTask

@Dao
interface HomeDao : BaseDao<Category> {

    @Query("SELECT DISTINCT * FROM CATEGORY INNER JOIN TASK ON CATEGORY.categoryId = TASK.categoryId")
    suspend fun getAllCategories(): List<Category>

    @Transaction
    @Query("SELECT * FROM CATEGORY")
    fun getCategoriesWithTask(): List<CategoriesWithTask>
}