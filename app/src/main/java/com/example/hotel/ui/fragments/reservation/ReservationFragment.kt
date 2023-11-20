package com.example.hotel.ui.fragments.reservation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.domain.models.Reservation
import com.example.domain.models.ResponseResult
import com.example.hotel.R
import com.example.hotel.databinding.FragmentReservationBinding
import com.example.hotel.extensions.navigateSafe
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReservationFragment : Fragment() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        FragmentReservationBinding.inflate(
            layoutInflater
        )
    }
    private val viewModel: ReservationViewModel by viewModel()
    private val reservationAdapter by lazy(LazyThreadSafetyMode.NONE) {
        ReservationAdapter(touristList)
    }

    private var touristCount: Int = 1
    private val touristName: String = "Турист"

    private val touristList: MutableList<TouristItem> =
        mutableListOf(TouristItem(id = touristCount, "$touristName$touristCount"))

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
            recyclerView.apply {
                adapter = reservationAdapter
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
        viewModel.reservationLiveData.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ResponseResult.Success -> {
                    result.data?.let { bindData(it) }
                }

                is ResponseResult.Error -> {}
                is ResponseResult.Failure -> {}
            }
        }
        binding.apply {
            btnPlus.setOnClickListener {
                touristCount++
                touristList.add(TouristItem(id = touristCount, name = "$touristName$touristCount"))
                reservationAdapter.setNewList(touristList)
            }
            btnPay.setOnClickListener {
                findNavController().navigateSafe(ReservationFragmentDirections.actionReservationFragmentToPaymentFragment())
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun bindData(reservation: Reservation) {
        with(binding) {
            with(reservation) {
                tvStar.text = "$horating $rating_name"
                tvHotelName.text = hotel_name
                tvAdress.text = hotel_adress
                tvDepartureFrom.text = departure
                tvToCountry.text = arrival_country
                tvToDate.text = "$tour_date_start - $tour_date_stop"
                tvToNight.text = number_of_nights.toString()
                tvToHotel.text = hotel_name
                tvToNumber.text = room
                tvToNutrition.text = nutrition
                tvTourMoney.text = tour_price.toString()
                tvGasMoney.text = fuel_charge.toString()
                tvServiceMoney.text = service_charge.toString()
                btnPay.text = "${btnPay.text} ${tour_price + fuel_charge + service_charge} ₽"
            }
        }
    }
}
