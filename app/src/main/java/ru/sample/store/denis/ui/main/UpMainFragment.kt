package ru.sample.store.denis.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.fragment.app.Fragment
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import ru.sample.store.denis.R
import ru.sample.store.denis.databinding.FragmentUpMainBinding
import ru.sample.store.denis.model.DataCardBestSeller
import ru.sample.store.denis.model.DataCardHotSales

class UpMainFragment: Fragment() {

    private var _binding: FragmentUpMainBinding? = null
    private val binding get() = _binding!!

    private val bottom_badge_length = 2

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

        binding.iconFilter.setOnClickListener {
            showMessageBox()
        }

        binding.bottomNavigation.apply {

            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.bottom_bag -> {
                        requireActivity()
                            .supportFragmentManager
                            .beginTransaction()
                            .addToBackStack("")
                            .replace(R.id.container, MyCartFragment.newInstance())
                            .commit()
                        true
                    }
                    else -> true
                }
            }
            val badge = binding.bottomNavigation.getOrCreateBadge(R.id.bottom_bag)
            badge.number = 4
            badge.maxCharacterCount = bottom_badge_length
            badge.badgeGravity = BadgeDrawable.BOTTOM_START


        }
    }

    @SuppressLint("RestrictedApi")
    fun showMessageBox(){

        //Inflate the dialog as custom view
        val messageBoxView = LayoutInflater.from(activity).inflate(R.layout.message_box, null)

        //AlertDialogBuilder
        val messageBoxBuilder = MaterialAlertDialogBuilder(requireActivity(), R.style.MaterialAlertDialog_rounded).setView(messageBoxView)

        //show dialog
        val  messageBoxInstance = messageBoxBuilder.show()
        messageBoxInstance.window?.setGravity(Gravity.BOTTOM)
        messageBoxInstance.window?.setLayout(MATCH_PARENT, WRAP_CONTENT)

        //set Listener
        messageBoxView.setOnClickListener(){
            //close dialog
            messageBoxInstance.dismiss()
        }

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}