package ru.sample.store.denis.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.sample.store.denis.databinding.CardMyCartBinding
import ru.sample.store.denis.model.DataCardMyCart

class RecyclerMyCart (private val listData: List<DataCardMyCart>) :
RecyclerView.Adapter<RecyclerMyCart.MyCartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCartViewHolder {
        val binding = CardMyCartBinding.inflate(LayoutInflater.from(parent.context))
        return MyCartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyCartViewHolder, position: Int) {
        val dataCardMyCart = listData[position]
        holder.bind(dataCardMyCart)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class MyCartViewHolder(private val binding: CardMyCartBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dataCardMyCart: DataCardMyCart) {

            binding.myCartContainer.setBackgroundResource(dataCardMyCart.picture)
            binding.tvTitle.text = dataCardMyCart.title
            binding.tvPrice.text = dataCardMyCart.price
        }
    }
}