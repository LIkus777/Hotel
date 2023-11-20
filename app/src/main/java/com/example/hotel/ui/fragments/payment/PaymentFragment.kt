package com.example.hotel.ui.fragments.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hotel.R
import com.example.hotel.databinding.FragmentPaymentBinding
import com.example.hotel.extensions.navigateSafe

class PaymentFragment : Fragment() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        FragmentPaymentBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            toolbar.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.back -> {
                        parentFragmentManager.popBackStack()
                        true
                    }

                    else -> {
                        false
                    }
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnSuper.setOnClickListener {
                findNavController().navigateSafe(PaymentFragmentDirections.actionPaymentFragmentToHotelFragment())
            }
        }
    }
}
