package dev.theuzfaleiro.maybetoday.ui.feature.task

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import dev.theuzfaleiro.maybetoday.R
import dev.theuzfaleiro.maybetoday.databinding.TaskFragmentBinding
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Task
import dev.theuzfaleiro.maybetoday.ui.feature.task.viewmodel.TaskViewModel
import kotlinx.android.synthetic.main.task_fragment.*
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class TaskFragment : Fragment(R.layout.task_fragment) {

    private val taskViewModel: TaskViewModel by viewModel()

    private lateinit var binding: TaskFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpBinding(view)

        observeEventsFromLiveData()

        setUpListeners()
    }

    private fun setUpBinding(view: View) {
        binding = TaskFragmentBinding.bind(view)
    }

    private fun observeEventsFromLiveData() {
        taskViewModel.taskLiveData.observe(viewLifecycleOwner) { taskState ->
            when (taskState) {
                TaskViewModel.TaskState.Inserted -> {
                    Toast.makeText(requireContext(), "SHOW", Toast.LENGTH_SHORT).show()
                }
            }
        }

        taskViewModel.categoriesLiveData.observe(viewLifecycleOwner) { taskState ->
            taskState.forEach {
                it.name
            }
        }

        taskViewModel.categoriesLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it.first().name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setUpListeners() {

        val taskToBeCreated = Task(
            categoryId = 1L,
            taskTitle = binding.textInputEditTextAddNewTask.toString(),
            dueDate = binding.textInputEditTextAddNewTask.toString(),
            taskDescription = binding.textInputEditTextAddNewTask.toString(),
        )


        materialButtonAddNewTask.setOnClickListener {
            taskViewModel.createNewTask(taskToBeCreated)
        }
    }
}