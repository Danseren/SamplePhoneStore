package ru.sample.store.denis.ui.main

import android.R.*
import android.R.layout.simple_spinner_item
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import ru.sample.store.denis.R
import ru.sample.store.denis.databinding.FragmentUpMainBinding
import ru.sample.store.denis.model.DataCardCategory

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

        val dataCardCategory = arrayListOf(
            DataCardCategory(R.drawable.ic_phone_24, "Phones"),
            DataCardCategory(R.drawable.ic_computer_24, "Computer"),
            DataCardCategory(R.drawable.ic_health_24, "Health"),
            DataCardCategory(R.drawable.ic_books_24, "Books"),
            DataCardCategory(R.drawable.ic_other_24, "Other")
        )
        binding.recyclerViewCategory.adapter = RecyclerCardCategoryAdapter(dataCardCategory)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}