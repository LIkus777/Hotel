package com.example.hotel.ui.fragments.room

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.domain.models.ResponseResult
import com.example.hotel.databinding.FragmentRoomBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RoomFragment : Fragment() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) { FragmentRoomBinding.inflate(layoutInflater) }
    private val viewModel: RoomViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.roomLiveData.observe(viewLifecycleOwner) { result ->
            when(result) {
                is ResponseResult.Success -> {
                    Log.i("TAG", "onViewCreated: ${result.data}") }
                is ResponseResult.Error -> {}
                is ResponseResult.Failure -> {}
            }
        }
    }
}
