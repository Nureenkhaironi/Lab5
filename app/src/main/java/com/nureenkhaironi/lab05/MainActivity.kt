package com.nureenkhaironi.lab05

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nureenkhaironi.lab05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.button.setOnClickListener {
            var pizzaSizePrice = 0.0
            var toppingsTotal = 0.0

            when {

                binding.smallRadioBtn.isChecked -> pizzaSizePrice = 5.0
                binding.mediumRadioBtn.isChecked -> pizzaSizePrice = 7.0
                binding.LargeRadioBtn.isChecked -> pizzaSizePrice = 9.0
            }

            if (binding.onionsBox.isChecked) {
                toppingsTotal += 1
            }

            if (binding.olivesBox2.isChecked) {
                toppingsTotal += 2
            }

            if (binding.tomatoesBox3.isChecked) {
                toppingsTotal += 3
            }

            val totalOrderPrice = pizzaSizePrice + toppingsTotal
            binding.totalTextView.text = "Total Order Price = RM ${pizzaSizePrice + toppingsTotal}"
        }
    }
}