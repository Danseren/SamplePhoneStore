package ru.sample.store.denis.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.sample.store.denis.MainActivity
import ru.sample.store.denis.R
import ru.sample.store.denis.databinding.FragmentProductDetailsBinding
import ru.sample.store.denis.model.DataCardDetails

class ProductDetailsFragment: Fragment() {

    private var _binding: FragmentProductDetailsBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ProductDetailsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataCardDetails = arrayListOf(
            DataCardDetails(R.drawable.samsung_note_20_ultra),
            DataCardDetails(R.drawable.samsung_note_20_ultra_3),
            DataCardDetails(R.drawable.samsung_note_20_ultra_2)
        )

        binding.recyclerProductDetails.adapter = RecyclerDetails(dataCardDetails)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}