package dev.theuzfaleiro.maybetoday.ui.feature.home.adapter

import androidx.recyclerview.widget.DiffUtil
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category

class HomeDiffCallback : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean =
        oldItem == newItem
}
