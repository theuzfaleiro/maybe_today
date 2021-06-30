package dev.theuzfaleiro.maybetoday.ui.feature.task.di.module

import dev.theuzfaleiro.maybetoday.ui.feature.task.repository.TaskRepository
import dev.theuzfaleiro.maybetoday.ui.feature.task.viewmodel.TaskViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val taskModule = module {
    factory {
        TaskRepository(taskDao = get())
    }

    viewModel {
        TaskViewModel(taskRepository = get())
    }
}