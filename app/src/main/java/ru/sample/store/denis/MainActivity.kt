package ru.sample.store.denis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.sample.store.denis.databinding.ActivityMainBinding
import ru.sample.store.denis.ui.main.UpMainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, UpMainFragment.newInstance())
                .commitNow()
        }
    }

}