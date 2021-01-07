package dev.theuzfaleiro.maybetoday.ui.feature.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.theuzfaleiro.maybetoday.R
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Task

class HomeAdapter :
    ListAdapter<Task, HomeAdapter.HomeViewHolder>(HomeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.home_category_item, parent, false)
        )

    override fun onBindViewHolder(homeViewHolder: HomeViewHolder, position: Int) {
        homeViewHolder.bindItemsToView(getItem(position))
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItemsToView(task: Task) {

        }
    }
}
