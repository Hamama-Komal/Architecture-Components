package com.example.architecturecomponents.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.architecturecomponents.R
import com.example.architecturecomponents.classes.LiveDataViewModel
import com.example.architecturecomponents.databinding.ActivityLiveDataBinding

class LiveDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLiveDataBinding

    lateinit var liveDataViewModel: LiveDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLiveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Live Data and Mutable Live Data

        liveDataViewModel = ViewModelProvider(this).get(LiveDataViewModel::class.java)

        liveDataViewModel.quoteLiveData.observe(this, Observer {
            // code logic here
            binding.textView.text = it
        })

        binding.button.setOnClickListener{

            // Mutable Live Data can be updated

            liveDataViewModel.updateLiveData()
           // liveDataViewModel.quoteMutableLiveData.value = "Fate is in your hands and no one else"
        }
    }
}