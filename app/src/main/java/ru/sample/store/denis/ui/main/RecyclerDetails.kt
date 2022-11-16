package ru.sample.store.denis.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.sample.store.denis.databinding.CardDetailsBinding
import ru.sample.store.denis.model.DataCardDetails

class RecyclerDetails (private val listData: List<DataCardDetails>) :
RecyclerView.Adapter<RecyclerDetails.DetailsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val binding = CardDetailsBinding.inflate(LayoutInflater.from(parent.context))
        return DetailsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        val dataCardDetails = listData[position]
        holder.bind(dataCardDetails)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class DetailsViewHolder(private val binding: CardDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dataCardBestSeller: DataCardDetails) {

            binding.cardContainer.setBackgroundResource(dataCardBestSeller.picture)

        }
    }
}