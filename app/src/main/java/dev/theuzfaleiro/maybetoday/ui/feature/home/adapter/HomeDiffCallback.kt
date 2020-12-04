package dev.theuzfaleiro.maybetoday.ui.feature.home.adapter

import androidx.recyclerview.widget.DiffUtil
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Task

class HomeDiffCallback : DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean =
        oldItem == newItem
}