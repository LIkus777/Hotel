package com.example.hotel.ui.fragments.reservation

import android.annotation.SuppressLint
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hotel.databinding.ItemReservationCollapsedBinding
import com.example.hotel.extensions.POST_DELAY
import com.google.android.material.textview.MaterialTextView

class ReservationAdapter(
    private var touristItems: List<TouristItem>,
) : RecyclerView.Adapter<ReservationAdapter.ViewHolder>() {

    inner class ViewHolder(binding: ItemReservationCollapsedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val touristName: MaterialTextView = binding.tvTourist
        val btnHide = binding.btnHide
        val list: RecyclerView = binding.recyclerView
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReservationAdapter.ViewHolder {
        return ViewHolder(
            ItemReservationCollapsedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ReservationAdapter.ViewHolder, position: Int) {
        val item = touristItems[position]
        Log.i("TAG", "onBindViewHolder: ${touristItems[position]}")
        with(holder) {
            touristName.text = item.name
            btnHide.setOnClickListener {
                when (list.visibility) {
                    VISIBLE -> {
                        Handler().postDelayed({ list.visibility = GONE }, POST_DELAY)
                    }

                    GONE -> {
                        list.visibility = VISIBLE
                    }
                }
                list.adapter = NestedAdapter()
            }
        }
    }

    override fun getItemCount(): Int = touristItems.size

    @SuppressLint("NotifyDataSetChanged")
    fun setNewList(newTouristItems: List<TouristItem>) {
        touristItems = newTouristItems
        this.notifyDataSetChanged()
    }
}
