package dev.theuzfaleiro.maybetoday.ui.feature.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.theuzfaleiro.maybetoday.R
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Task
import kotlinx.android.synthetic.main.task_item.view.*

class HomeAdapter :
    ListAdapter<Task, HomeAdapter.HomeViewHolder>(HomeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        )

    override fun onBindViewHolder(homeViewHolder: HomeViewHolder, position: Int) {
        homeViewHolder.bindItemsToView(getItem(position))
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val taskTitle: TextView = itemView.textViewTaskTitle

        fun bindItemsToView(task: Task) {
            taskTitle.text = task.taskTitle
        }
    }
}
