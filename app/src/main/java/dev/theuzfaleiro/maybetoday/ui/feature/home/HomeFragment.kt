package dev.theuzfaleiro.maybetoday.ui.feature.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import dev.theuzfaleiro.maybetoday.R
import dev.theuzfaleiro.maybetoday.databinding.HomeFragmentBinding
import dev.theuzfaleiro.maybetoday.ui.feature.home.adapter.HomeAdapter
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category
import dev.theuzfaleiro.maybetoday.ui.feature.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val NUMBER_OF_COLUMNS = 2

class HomeFragment : Fragment(R.layout.home_fragment) {

    private val viewModel: HomeViewModel by viewModel()

    private val homeAdapter = HomeAdapter()

    private lateinit var binding: HomeFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpBinding(view)
        setUpViewListeners()
        setupRecyclerView()

        observeViewModelEvents()
    }

    private fun setUpBinding(view: View) {
        binding = HomeFragmentBinding.bind(view)
    }

    private fun setUpViewListeners() {
        floatingActionButtonAddNewTask.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_taskFragment)
        }
    }

    private fun setupRecyclerView() {
        with(binding.recyclerViewHomeCategories) {
            setHasFixedSize(true)
            adapter = homeAdapter
            layoutManager =
                GridLayoutManager(requireContext(), NUMBER_OF_COLUMNS)
        }
    }

    private fun observeViewModelEvents() {
        viewModel.categoryLiveData.observe(viewLifecycleOwner) {
            homeAdapter.submitList(
                listOf(
                    Category(0, "TEST", "TEST"),
                    Category(0, "TEST", "TEST"),
                    Category(0, "TEST", "TEST"),
                    Category(0, "TEST", "TEST")
                )
            )
        }

        viewModel.getAllCategories()
    }
}