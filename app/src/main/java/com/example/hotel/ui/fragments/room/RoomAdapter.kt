package com.example.hotel.ui.fragments.room

import android.annotation.SuppressLint
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
import com.example.hotel.extensions.bindPeculiarities
import com.synnapps.carouselview.ImageListener

class RoomAdapter(
    private val onChooseRoomClick: () -> Unit,
    private val loadImage: (uri: Uri, imageView: ImageView) -> Unit
) : ListAdapter<Room, RoomAdapter.ViewHolder>(DIFF_CALLBACK) {

    inner class ViewHolder(private val bindind: ItemRoomBinding) : RecyclerView.ViewHolder(bindind.root) {
        @SuppressLint("SetTextI18n")
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
