package dev.theuzfaleiro.maybetoday.ui.feature.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.theuzfaleiro.maybetoday.R
import dev.theuzfaleiro.maybetoday.databinding.HomeCategoryItemBinding
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category

class HomeAdapter :
    ListAdapter<Category, HomeAdapter.HomeViewHolder>(HomeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.home_category_item, parent, false)
        )

    override fun onBindViewHolder(homeViewHolder: HomeViewHolder, position: Int) {
        homeViewHolder.bindItemsToView(getItem(position))
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val homeCategoryBinding = HomeCategoryItemBinding.bind(itemView)

        private val categoryTitle = homeCategoryBinding.textViewCategoryTitle
        private val categoryDescription = homeCategoryBinding.textViewNumberOfTasks

        fun bindItemsToView(category: Category) {
            categoryTitle.text = categoryTitle.text
            categoryDescription.text = categoryTitle.text
        }
    }
}