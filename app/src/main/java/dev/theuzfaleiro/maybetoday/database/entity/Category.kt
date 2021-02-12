package dev.theuzfaleiro.maybetoday.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "CATEGORY")
data class Category(
    @PrimaryKey(autoGenerate = true)
    val categoryId: Long = 0,
    val categoryName: String
)