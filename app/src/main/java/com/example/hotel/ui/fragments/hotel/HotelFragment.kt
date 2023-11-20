package com.example.hotel.ui.fragments.hotel

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.domain.models.Hotel
import com.example.domain.models.ResponseResult
import com.example.hotel.databinding.FragmentHotelBinding
import com.example.hotel.extensions.bindPeculiarities
import com.example.hotel.extensions.navigateSafe
import com.synnapps.carouselview.ImageListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class HotelFragment : Fragment() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        FragmentHotelBinding.inflate(
            layoutInflater
        )
    }
    private val viewModel: HotelViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.hotelLiveData.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ResponseResult.Success -> {
                    result.data?.let { bindData(it) }
                }

                is ResponseResult.Error -> {}
                is ResponseResult.Failure -> {}
            }
        }
        binding.btnToRoomChoose.setOnClickListener {
            findNavController().navigateSafe(HotelFragmentDirections.actionHotelFragmentToRoomFragment())
        }
    }

    @SuppressLint("SetTextI18n")
    private fun bindData(hotel: Hotel) {
        with(binding) {
            with(hotel) {
                tvStar.text = "$rating $rating_name"
                tvHotelName.text = name
                tvAdress.text = adress
                tvPrice.text = "${tvPrice.text} $minimal_price ₽"
                tvPriceForIt.text = price_for_it
                tvHotelDescription.text = about_the_hotel.description

                bindPeculiarities(
                    listOf(peculiarities1, peculiarities2, peculiarities3, peculiarities4),
                    about_the_hotel.peculiarities
                )

                val imgListener = ImageListener { position, imageView ->
                    if (imageView != null) {
                        Glide.with(requireContext())
                            .load(image_urls[position].toUri())
                            .into(imageView)
                    }
                }

                binding.carousel.setImageListener(imgListener)
                binding.carousel.pageCount = image_urls.size
            }
        }
    }
}
