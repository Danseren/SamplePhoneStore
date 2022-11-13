package ru.sample.store.denis.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.sample.store.denis.R
import ru.sample.store.denis.databinding.FragmentUpMainBinding
import ru.sample.store.denis.model.DataCardBestSeller
import ru.sample.store.denis.model.DataCardHotSales

class UpMainFragment: Fragment() {

    private var _binding: FragmentUpMainBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = UpMainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataCardHotSales = arrayListOf(
            DataCardHotSales(R.drawable.iphone12, true, "Iphone 12", "Súper. Mega. Rápido." ),
            DataCardHotSales(R.drawable.xiaomi_mi_11_ultra, false, "Xiaomi Mi 11 ultra", "Súper. Mega. Rápido." ),
            DataCardHotSales(R.drawable.samsung_galaxy_a71, false, "Samsung Galaxy A71", "Súper. Mega. Rápido." )
        )
        val dataCardBestSeller = arrayListOf(
            DataCardBestSeller(R.drawable.samsung_galaxy_s20_ultra, "Samsung Galaxy s20 Ultra", "1,500", "1,047", true),
            DataCardBestSeller(R.drawable.xiaomi_mi_10_pro, "Xiaomi Mi 10 Pro", "400", "300", true ),
            DataCardBestSeller(R.drawable.samsung_note_20_ultra, "Samsung Note 20 Ultra", "1,500", "1,047", true ),
            DataCardBestSeller(R.drawable.motorola_one_edge, "Motorola One Edge ", "400", "300", true )
        )
        binding.recyclerViewHotSales.adapter = RecyclerCardHotSalesAdapter(dataCardHotSales)
        binding.recyclerViewBestSellers.adapter = RecyclerCardBestSellerAdapter(dataCardBestSeller)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}