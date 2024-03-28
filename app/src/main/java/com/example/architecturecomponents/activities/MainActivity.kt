package com.example.architecturecomponents.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.architecturecomponents.classes.MainViewModel
import com.example.architecturecomponents.classes.MainViewModelFactory
import com.example.architecturecomponents.classes.Observer
import com.example.architecturecomponents.R
import com.example.architecturecomponents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    val COUNTER_STARTING_VALUE : Int = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // LifeCycle Observer
         // observer()

        // View Model and View Model Factory
           mainViewModel()

    }

    private fun mainViewModel() {
        // viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel = ViewModelProvider(this, MainViewModelFactory(COUNTER_STARTING_VALUE)).get(
            MainViewModel::class.java)

        setText()

        binding.btnCount.setOnClickListener {
            viewModel.increment()
            setText()
        }
    }

    private fun setText() {
        binding.textShowCount.text = viewModel.count.toString()
    }

    private fun observer() {

        lifecycle.addObserver(Observer())
        // For onCreate method of activity
        Log.d("Main","Activity - OnCreate")  // Here Activity create first
    }

    override fun onStart() {
        super.onStart()
        Log.d("Main","Activity - OnStart")   // Here Activity start first
    }

    override fun onStop() {
        super.onStop()
        Log.d("Main","Activity - OnStop")     // Here Observer stops first
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Main","Activity - OnDestroy")     // Here Observer destroy first
    }

    override fun onResume() {
        super.onResume()
        Log.d("Main","Activity - OnResume")     // Here Activity resume first
    }

    override fun onPause() {
        super.onPause()
        Log.d("Main","Activity - OnPause")   // Here Observer pause first
    }
}