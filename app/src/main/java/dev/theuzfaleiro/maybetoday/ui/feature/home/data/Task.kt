package dev.theuzfaleiro.maybetoday.ui.feature.home.data

data class Task(
    val id: Long = 0,
    val taskTitle: String,
    val dueDate: String,
    val taskDescription: String,
)