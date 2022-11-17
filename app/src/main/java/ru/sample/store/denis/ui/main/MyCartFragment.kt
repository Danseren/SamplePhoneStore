package ru.sample.store.denis.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.sample.store.denis.databinding.FragmentMyCartBinding
import ru.sample.store.denis.model.DataCardMyCart

class MyCartFragment: Fragment() {

    private var _binding: FragmentMyCartBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MyCartFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyCartBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataCardMyCart = arrayListOf(
            DataCardMyCart(),
            DataCardMyCart()
        )

        binding.recyclerMyCart.adapter = RecyclerMyCart(dataCardMyCart)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}