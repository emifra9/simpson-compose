package com.emifra9.cellphones.view.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.emifra9.cellphones.R
import com.emifra9.cellphones.data.dto.Images

class ImageAdapter(private var context: Context, private var imageURLList : List<Images>): RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_img_bottom_sheet, parent, false)
        return  ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageUrls = imageURLList[position]
        val imageView = holder.imageView
        Glide.with(context)
            .load(imageUrls.url)
            .placeholder(R.drawable.cell_placeholder)
            .into(imageView)
    }

    override fun getItemCount(): Int {
        return imageURLList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.image_view)
    }
}