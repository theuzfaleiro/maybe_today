package dev.theuzfaleiro.maybetoday.ui.feature.task.di.module

import dev.theuzfaleiro.maybetoday.ui.feature.task.repository.TaskRepository
import dev.theuzfaleiro.maybetoday.ui.feature.task.viewmodel.TaskViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val taskModule = module {
    factory {
        TaskRepository(taskDAO = get())
    }

    viewModel {
        TaskViewModel(taskRepository = get())
    }
}