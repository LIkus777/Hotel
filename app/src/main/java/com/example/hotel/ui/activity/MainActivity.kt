package com.example.hotel.ui.activity

import com.example.hotel.ui.base.BaseMainActivity
import com.example.hotel.ui.base.BaseMainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseMainActivity() {
    override val mainViewModel: BaseMainViewModel by viewModel()
}
