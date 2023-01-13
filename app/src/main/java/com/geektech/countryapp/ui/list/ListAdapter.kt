package com.geektech.countryapp.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geektech.countryapp.R
import com.geektech.countryapp.databinding.ItemListBinding
import com.geektech.countryapp.model.CountryItem

class ListAdapter(private val list: List<CountryItem>) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    inner class ListViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: CountryItem) {
            Glide.with(binding.imgCountry).load(position.flags?.png).into(binding.imgCountry)
            binding.txtNameOfCountry.text = position.name
            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putParcelable("key", position)
                it.findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}