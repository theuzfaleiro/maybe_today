package dev.theuzfaleiro.maybetoday.ui.feature.home.di.module

import dev.theuzfaleiro.maybetoday.ui.feature.home.repository.HomeRepository
import dev.theuzfaleiro.maybetoday.ui.feature.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    factory {
        HomeRepository(homeDAO = get())
    }

    viewModel {
        HomeViewModel(homeRepository = get())
    }
}