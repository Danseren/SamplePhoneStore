package ru.sample.store.denis.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.sample.store.denis.R
import ru.sample.store.denis.databinding.CardRecyclerCategoryBinding
import ru.sample.store.denis.model.DataCardCategory

class RecyclerCardCategoryAdapter(private val listData: List<DataCardCategory>) :
    RecyclerView.Adapter<RecyclerCardCategoryAdapter.CardCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardCategoryViewHolder {
        val binding = CardRecyclerCategoryBinding.inflate(LayoutInflater.from(parent.context))
        return CardCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardCategoryViewHolder, position: Int) {
        val dataCardCategory = listData[position]
        holder.bind(dataCardCategory)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class CardCategoryViewHolder(val binding: CardRecyclerCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dataCardCategory: DataCardCategory) {
            binding.tvDescription.text = dataCardCategory.description
            binding.checkbox.setButtonDrawable(dataCardCategory.picture)
        }
    }

}