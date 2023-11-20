package com.example.hotel.ui.fragments.room

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.domain.models.ResponseResult
import com.example.domain.models.Room
import com.example.hotel.databinding.FragmentRoomBinding
import com.example.hotel.extensions.navigateSafe
import org.koin.androidx.viewmodel.ext.android.viewModel

class RoomFragment : Fragment() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) { FragmentRoomBinding.inflate(layoutInflater) }
    private val viewModel: RoomViewModel by viewModel()
    private val roomAdapter by lazy(LazyThreadSafetyMode.NONE) {
        RoomAdapter(onChooseRoomClick = { toReservation()}, loadImage = { uri, imageView -> glideLoad(uri, imageView) })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            recyclerView.apply {
                adapter = roomAdapter
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
        viewModel.roomLiveData.observe(viewLifecycleOwner) { result ->
            when(result) {
                is ResponseResult.Success -> {
                    Log.i("TAG", "onViewCreated: ${result.data}")
                    Log.i("TAG", "onViewCreated: ${result.data?.rooms}")
                    roomAdapter.submitList(result.data?.rooms)
                }
                is ResponseResult.Error -> {}
                is ResponseResult.Failure -> {}
            }
        }
    }

    private fun glideLoad(uri: Uri, imageView: ImageView) {
        Glide.with(requireContext())
            .load(uri)
            .into(imageView)
    }

    private fun toReservation() {
        findNavController().navigateSafe(RoomFragmentDirections.actionRoomFragmentToReservationFragment())
    }

}
