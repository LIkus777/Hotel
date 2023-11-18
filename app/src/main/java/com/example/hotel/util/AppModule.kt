package com.example.hotel.util

import com.example.hotel.ui.BaseMainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { BaseMainViewModel() }
}