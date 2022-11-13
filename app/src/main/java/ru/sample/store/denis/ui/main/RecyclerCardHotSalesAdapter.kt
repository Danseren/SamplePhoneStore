package ru.sample.store.denis.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.sample.store.denis.databinding.CardRecyclerHotSalesBinding
import ru.sample.store.denis.model.DataCardHotSales

class RecyclerCardHotSalesAdapter(private val listData: List<DataCardHotSales>) :
    RecyclerView.Adapter<RecyclerCardHotSalesAdapter.CardHotSalesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHotSalesViewHolder {
        val binding = CardRecyclerHotSalesBinding.inflate(LayoutInflater.from(parent.context))
        return CardHotSalesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardHotSalesViewHolder, position: Int) {
        val dataCardHotSales = listData[position]
        holder.bind(dataCardHotSales)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class CardHotSalesViewHolder(private val binding: CardRecyclerHotSalesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dataCardHotSales: DataCardHotSales) {

            binding.cardContainer.setBackgroundResource(dataCardHotSales.picture)
            binding.tvBrand.text = dataCardHotSales.title
            binding.tvDescription.text = dataCardHotSales.subtitle
            if (dataCardHotSales.newStatus) {
                binding.btnNew.visibility = View.VISIBLE
            } else binding.btnNew.visibility = View.INVISIBLE
        }
    }

}