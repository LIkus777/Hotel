package com.example.hotel.ui.fragments.hotel

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import coil.load
import com.bumptech.glide.Glide
import com.example.domain.models.ResponseResult
import com.example.hotel.R
import com.example.hotel.databinding.FragmentHotelBinding
import com.synnapps.carouselview.ImageListener
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.net.URL


class HotelFragment : Fragment() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        FragmentHotelBinding.inflate(
            layoutInflater
        )
    }
    private val viewModel: HotelViewModel by viewModel()

    private val images = arrayListOf(
        R.drawable.hotel_image,
        R.drawable.hotel_image,
        R.drawable.hotel_image,
        R.drawable.hotel_image,
        R.drawable.hotel_image,
        R.drawable.hotel_image,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            /*carousel.apply {
                pageCount = images.size
                setImageListener { position, imageView -> imageView?.setImageResource(images[position]) }
            }*/
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.hotelLiveData.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ResponseResult.Success -> {
                    Log.i("TAG", "onViewCreated: ${result.data}")
                    with(binding) {
                        with(result.data) {
                            this?.let {
                                tvStar.text = "${rating} $rating_name"
                                tvHotelName.text = name
                                tvAdress.text = adress
                                tvPrice.text = "${tvPrice.text} ${minimal_price}"
                                tvPriceForIt.text = price_for_it
                                tvHotelDescription.text = about_the_hotel.description
                                hint1.text = about_the_hotel.peculiarities[0]
                                hint2.text = about_the_hotel.peculiarities[1]
                                hint3.text = about_the_hotel.peculiarities[2]
                                hint4.text = about_the_hotel.peculiarities[3]

                                binding.carousel.setImageListener(){ position, imageView ->



                                }
                                binding.carousel.pageCount = image_urls.size

                                object : ImageListener {
                                    override fun setImageForPosition(
                                        position: Int,
                                        imageView: ImageView?
                                    ) {
                                        image_urls.forEachIndexed { index, url ->
                                            Log.i("TAG", "onViewCreated: URL - $url")
                                            Log.i("TAG", "onViewCreated: URLLLL - $url")
                                            Glide.with(requireContext())
                                                .load(url.toUri())
                                                .into(imageView)
                                        }
                                    }
                                }
                            }

                        }
                    }
                }

                is ResponseResult.Error -> {}
                is ResponseResult.Failure -> {}
            }
        }

        /*viewModel.hotelImages.observe(viewLifecycleOwner) { imgUrlResult ->
            Log.i("TAG", "onViewCreated: RES - ${imgUrlResult}")
            when (imgUrlResult) {
                is ResponseResult.Success -> {
                    binding.carousel.setImageListener { position, imageView ->
                        imageView?.setImageURI(imgUrlResult.data?.let {
                            it.toUri().buildUpon().scheme("https").build()
                        })
                    }
                }

                is ResponseResult.Failure -> {}
                is ResponseResult.Error -> {}
            }

        }*/
    }

}