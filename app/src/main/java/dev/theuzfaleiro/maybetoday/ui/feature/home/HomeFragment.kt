package dev.theuzfaleiro.maybetoday.ui.feature.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import dev.theuzfaleiro.maybetoday.R
import dev.theuzfaleiro.maybetoday.databinding.HomeFragmentBinding
import dev.theuzfaleiro.maybetoday.ui.feature.home.adapter.HomeAdapter
import dev.theuzfaleiro.maybetoday.ui.feature.home.viewmodel.HomeViewModel
import dev.theuzfaleiro.maybetoday.ui.feature.home.viewmodel.States
import dev.theuzfaleiro.maybetoday.ui.feature.home.viewmodel.States.Success
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val NUMBER_OF_COLUMNS = 2

class HomeFragment : Fragment(R.layout.home_fragment) {

    private val viewModel: HomeViewModel by viewModel()

    private val homeAdapter: HomeAdapter by lazy {
        HomeAdapter {
            Toast.makeText(requireContext(), it.name, Toast.LENGTH_LONG).show()
        }
    }

    private lateinit var homeFragmentBinding: HomeFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpBinding(view)
        setUpViewListeners()
        setupRecyclerView()

        observeViewModelEvents()
    }

    private fun setUpBinding(view: View) {
        homeFragmentBinding = HomeFragmentBinding.bind(view)
    }

    private fun setUpViewListeners() {
        homeFragmentBinding.floatingActionButtonAddNewTask.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_taskFragment)
        }
    }

    private fun setupRecyclerView() {
        (homeFragmentBinding.recyclerViewHomeCategories).run {
            adapter = homeAdapter
            layoutManager =
                GridLayoutManager(requireContext(), NUMBER_OF_COLUMNS)
        }
    }

    private fun observeViewModelEvents() {
        viewModel.getAllCategoriesWithTask().observe(viewLifecycleOwner) { states ->
            when (states) {
                is States.Error -> homeFragmentBinding.viewFlipperHome.displayedChild = 1

                is States.Loading -> TODO()

                is Success -> {
                    homeFragmentBinding.viewFlipperHome.displayedChild = 0
                    homeAdapter.submitList(states.category)
                }
            }
        }

        viewModel.loadAllCategoriesWithTask()
    }
}