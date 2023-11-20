package com.example.hotel.ui.fragments.room

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Room
import com.example.hotel.databinding.ItemRoomBinding
import com.google.android.material.textview.MaterialTextView
import com.synnapps.carouselview.ImageListener

class RoomAdapter(
    private val onChooseRoomClick: () -> Unit,
    private val loadImage: (uri: Uri, imageView: ImageView) -> Unit
) : ListAdapter<Room, RoomAdapter.ViewHolder>(DIFF_CALLBACK) {

    inner class ViewHolder(private val bindind: ItemRoomBinding): RecyclerView.ViewHolder(bindind.root) {
        fun bindData(room: Room) {
            bindind.apply {
                with(room) {
                    tvHotelName.text = name
                    tvPrice.text = "$price ${tvPrice.text}"
                    tvPricePer.text = price_per
                    bindPeculiarities(listOf(peculiarities1, peculiarities2), peculiarities)
                    val imgListener = ImageListener { position, imageView ->
                        if (imageView != null) {
                            loadImage(image_urls[position].toUri(), imageView)
                        }
                    }
                    carousel.setImageListener(imgListener)
                    carousel.pageCount = image_urls.size
                    btnChooseRoom.setOnClickListener { onChooseRoomClick.invoke() }
                }
            }
        }
    }

    private fun bindPeculiarities(listTv: List<MaterialTextView>, listStrings: List<String>) {
        listStrings.forEachIndexed { index, s ->
            if (index < listTv.size) {
                listTv[index].text = s
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemRoomBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    private companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Room>() {
            override fun areItemsTheSame(old: Room, new: Room): Boolean = old.id == new.id
            override fun areContentsTheSame(old: Room, new: Room): Boolean = old == new
        }
    }
}