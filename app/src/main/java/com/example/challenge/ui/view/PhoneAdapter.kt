package com.example.challenge.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge.R
import com.example.challenge.databinding.PhoneItemBinding
import com.example.challenge.model.PhoneListItem
import com.squareup.picasso.Picasso

class PhoneAdapter(
    private val phones: ArrayList<PhoneListItem>,
    private val mListener:(String) -> Unit): RecyclerView.Adapter<PhoneViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PhoneViewHolder(layoutInflater.inflate(R.layout.phone_item,parent,false))
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        holder.bind(phones[position], mListener)
    }

    override fun getItemCount(): Int {
        return phones.size
    }
}

class PhoneViewHolder (view: View) : RecyclerView.ViewHolder(view){

    private val binding = PhoneItemBinding.bind(view)
    fun bind(phone:PhoneListItem, mListener: (String) -> Unit){
        Picasso.get().load(phone.mainImage.url).into(binding.imageView)
        binding.name.text= phone.name
        binding.installmentTag.text = phone.installmentsTag
        binding.topTag.text = phone.topTag
        binding.cardView.setOnClickListener { mListener(phone.id) }
    }

}
