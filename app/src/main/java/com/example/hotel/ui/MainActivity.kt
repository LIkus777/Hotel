package com.example.hotel.ui

import com.example.hotel.ui.BaseMainActivity
import com.example.hotel.ui.BaseMainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseMainActivity() {
    override val mainViewModel: BaseMainViewModel by viewModel()
}
