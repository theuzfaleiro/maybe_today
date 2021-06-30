package dev.theuzfaleiro.maybetoday.ui.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.theuzfaleiro.maybetoday.databinding.HomeCategoryItemBinding
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category

class HomeAdapter(private val categorySelected: (category: Category) -> Unit) :
    ListAdapter<Category, HomeAdapter.HomeViewHolder>(HomeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder.create(parent)
    }

    override fun onBindViewHolder(homeViewHolder: HomeViewHolder, position: Int) {
        homeViewHolder.bindItemsToView(getItem(position), categorySelected)
    }

    class HomeViewHolder(private val homeCategoryItemBinding: HomeCategoryItemBinding) :
        RecyclerView.ViewHolder(homeCategoryItemBinding.root) {

        fun bindItemsToView(category: Category, categorySelected: (category: Category) -> Unit) {
            homeCategoryItemBinding.textViewCategoryTitle.text = category.name
            homeCategoryItemBinding.textViewNumberOfTasks .text = category.name

            itemView.setOnClickListener {
                categorySelected(category)
            }
        }

        companion object {
            fun create(
                parent: ViewGroup,
            ): HomeViewHolder {
                val itemBinding = HomeCategoryItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )

                return HomeViewHolder(itemBinding)
            }
        }
    }
}