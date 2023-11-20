package com.example.hotel.ui.fragments.reservation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hotel.R
import com.example.hotel.databinding.ItemReservationExpandedBinding

class NestedAdapter : RecyclerView.Adapter<NestedAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemReservationExpandedBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData() {
            binding.apply {
                til1.hint = itemView.context.getString(R.string.hint_name)
                til2.hint = itemView.context.getString(R.string.hint_last_name)
                til3.hint = itemView.context.getString(R.string.hint_date_born)
                til4.hint = itemView.context.getString(R.string.hint_citizenship)
                til5.hint = itemView.context.getString(R.string.hint_passport_number)
                til6.hint = itemView.context.getString(R.string.hint_passport_date)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder (
        ItemReservationExpandedBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            bindData()
        }
    }
    override fun getItemCount(): Int = 1
}
