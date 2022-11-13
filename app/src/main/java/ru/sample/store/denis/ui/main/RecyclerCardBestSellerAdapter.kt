package ru.sample.store.denis.ui.main

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.sample.store.denis.databinding.CardRecyclerBestSellerBinding
import ru.sample.store.denis.model.DataCardBestSeller

class RecyclerCardBestSellerAdapter(private val listData: List<DataCardBestSeller>) :
    RecyclerView.Adapter<RecyclerCardBestSellerAdapter.CardBestSellerViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardBestSellerViewHolder {
        val binding = CardRecyclerBestSellerBinding.inflate(LayoutInflater.from(parent.context))
        return CardBestSellerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardBestSellerViewHolder, position: Int) {
        val dataCardBestSeller = listData[position]
        holder.bind(dataCardBestSeller)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class CardBestSellerViewHolder(private val binding: CardRecyclerBestSellerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dataCardBestSeller: DataCardBestSeller) {

            binding.cardContainer.setBackgroundResource(dataCardBestSeller.picture)
            binding.tvPrice.text = "$${dataCardBestSeller.price}"
            binding.tvDiscountPrice.apply {
                paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                text = "$${dataCardBestSeller.discountPrice}"
            }

            binding.tvTitle.text = dataCardBestSeller.title
            if (dataCardBestSeller.favorite) {
                binding.checkboxPhone.isChecked = true
            } else binding.checkboxPhone.isChecked = false
        }
    }
}