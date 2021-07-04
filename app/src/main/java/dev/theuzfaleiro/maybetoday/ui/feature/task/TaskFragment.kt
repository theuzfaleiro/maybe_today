package dev.theuzfaleiro.maybetoday.ui.feature.task

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dev.theuzfaleiro.maybetoday.R
import dev.theuzfaleiro.maybetoday.databinding.TaskFragmentBinding
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Category
import dev.theuzfaleiro.maybetoday.ui.feature.home.data.Task
import dev.theuzfaleiro.maybetoday.ui.feature.task.viewmodel.TaskViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class TaskFragment : Fragment(R.layout.task_fragment) {

    private val taskViewModel: TaskViewModel by viewModel()

    private lateinit var category: Category

    private lateinit var taskFragmentBinding: TaskFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpBinding(view)

        observeEventsFromLiveData()

        setUpListeners()
    }

    private fun setUpBinding(view: View) {
        taskFragmentBinding = TaskFragmentBinding.bind(view)
    }

    private fun observeEventsFromLiveData() {
        taskViewModel.categoriesLiveData.observe(viewLifecycleOwner) { taskState ->
            taskState.forEach {
                category = Category(it.id, it.name)
            }
        }

        taskViewModel.categoriesLiveData.observe(viewLifecycleOwner) {
            taskFragmentBinding.textInputEditTextCategory.append("it.first().name")
        }
    }

    private fun taskToBeCreated() = Task(
        categoryId = 2,
        taskTitle = "David",
        dueDate = taskFragmentBinding.textInputEditTextAddNewTask.toString(),
        taskDescription = "Luu",
    )

    private fun setUpListeners() {
        taskFragmentBinding.materialButtonAddNewTask.setOnClickListener {
            createNewTask()
        }
    }

    private fun createNewTask() {
        taskViewModel.createNewTask(taskToBeCreated())
    }
}
