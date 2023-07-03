package com.emifra9.cellphones.view.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.emifra9.cellphones.R
import com.emifra9.cellphones.databinding.ItemMobileBinding
import com.emifra9.cellphones.data.dto.Mobile


class MobileAdapter : RecyclerView.Adapter<MobileAdapter.MainViewHolder>() {

    private var mobiles = mutableListOf<Mobile>()

    private lateinit var onClickMobile: OnMobileClicked


    interface OnMobileClicked {
        fun onMobileClick(position: Int)
    }
    fun setOnClickMobile(onClick: OnMobileClicked) {
        this.onClickMobile = onClick
    }

    fun setMobilesList(mobiles: List<Mobile>) {
        this.mobiles = mobiles.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = ItemMobileBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val mobile = mobiles[position]
        holder.binding.name.text = mobile.name
        holder.binding.topTag.text = mobile.topTag
        holder.binding.installmentsTag.text = mobile.installmentsTag
        Glide.with(holder.itemView.context).load(mobile.mainImage.thumbnailUrl).placeholder(R.drawable.cell_placeholder).into(holder.binding.imgMobile)
        holder.binding.main.setOnClickListener { onClickMobile.onMobileClick( position) }

    }

    override fun getItemCount(): Int {
        return mobiles.size
    }
    inner class MainViewHolder(val binding: ItemMobileBinding) : RecyclerView.ViewHolder(binding.root)

}
