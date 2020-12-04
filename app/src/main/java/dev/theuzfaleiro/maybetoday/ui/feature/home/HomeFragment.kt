package dev.theuzfaleiro.maybetoday.ui.feature.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.theuzfaleiro.maybetoday.R
import dev.theuzfaleiro.maybetoday.ui.feature.home.adapter.HomeAdapter
import dev.theuzfaleiro.maybetoday.ui.feature.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.home_fragment) {

    private val viewModel: HomeViewModel by viewModel()

    private val homeAdapter = HomeAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewListeners()
        setupRecyclerView()

        observeViewModelEvents()
    }

    private fun setUpViewListeners() {
        floatingActionButtonAddNewTask.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_taskFragment)
        }
    }

    private fun setupRecyclerView() {
//        with(recyclerViewTaskList) {
//            setHasFixedSize(true)
//            adapter = homeAdapter
//            layoutManager =
//                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
//        }
    }

    private fun observeViewModelEvents() {
        viewModel.taskLiveData.observe(viewLifecycleOwner) {
            homeAdapter.submitList(it)
        }

        viewModel.getAllTasks()
    }
}