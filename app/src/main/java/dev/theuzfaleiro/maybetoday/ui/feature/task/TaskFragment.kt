package dev.theuzfaleiro.maybetoday.ui.feature.task

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import dev.theuzfaleiro.maybetoday.R
import dev.theuzfaleiro.maybetoday.ui.feature.task.viewmodel.TaskViewModel
import kotlinx.android.synthetic.main.task_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TaskFragment : Fragment(R.layout.task_fragment) {

    private val taskViewModel: TaskViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeEventsFromLiveData()

        setUpListeners()
    }

    private fun observeEventsFromLiveData() {
        taskViewModel.taskLiveData.observe(viewLifecycleOwner) { taskState ->
            when (taskState) {
                TaskViewModel.TaskState.Inserted -> {
                    Toast.makeText(requireContext(), "SHOW", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setUpListeners() {
        materialButtonAddNewTask.setOnClickListener {
            taskViewModel.addTask(
                textInputEditTextAddNewTask.text.toString(),
                textInputEditTextAddNewTask.text.toString()
            )
        }
    }
}