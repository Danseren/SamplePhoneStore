package ru.sample.store.denis.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.sample.store.denis.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val fragment = UpMainFragment()
//        val transaction = requireActivity().supportFragmentManager
//            .beginTransaction()
//            .replace(binding.upFrameLayout, fragment)
//            .commit()

        //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}