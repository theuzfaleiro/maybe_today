package dev.theuzfaleiro.maybetoday.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import dev.theuzfaleiro.maybetoday.database.entity.Category

data class CategoriesWithTask(
    @Embedded val category: Category,
    @Relation(parentColumn = "categoryId", entityColumn = "categoryId")
    val categoriesWithTask: List<Category>
)