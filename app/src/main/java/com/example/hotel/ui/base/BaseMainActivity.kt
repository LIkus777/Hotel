package com.example.hotel.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hotel.databinding.ActivityMainBinding

abstract class BaseMainActivity : AppCompatActivity() {

    protected val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(
            layoutInflater
        )
    }

    abstract val mainViewModel: BaseMainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
