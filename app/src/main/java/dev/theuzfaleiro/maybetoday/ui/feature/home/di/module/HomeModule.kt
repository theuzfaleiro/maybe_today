package dev.theuzfaleiro.maybetoday.ui.feature.home.di.module

import dev.theuzfaleiro.maybetoday.ui.feature.home.repository.HomeRepository
import dev.theuzfaleiro.maybetoday.ui.feature.home.viewmodel.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    factory {
        HomeRepository(homeDao = get())
    }

    viewModel {
        HomeViewModel(homeRepository = get())
    }
}
