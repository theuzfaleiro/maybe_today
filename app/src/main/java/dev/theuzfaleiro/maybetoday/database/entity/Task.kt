package dev.theuzfaleiro.maybetoday.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "TASK",
    foreignKeys = [ForeignKey(
        entity = Category::class,
        parentColumns = ["id"],
        childColumns = ["categoryId"]
    )]
)
data class Task(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")
    val id: Long = 0,
    @ColumnInfo(name = "categoryId")
    val categoryId: Long,
    @ColumnInfo(name = "taskTitle")
    val taskTitle: String,
    @ColumnInfo(name = "taskDescription")
    val taskDescription: String
)