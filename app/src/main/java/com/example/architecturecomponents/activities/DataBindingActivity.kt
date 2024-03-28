package com.example.architecturecomponents.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.architecturecomponents.R
import com.example.architecturecomponents.classes.DataBindingViewModel
import com.example.architecturecomponents.classes.QuoteDataClass
import com.example.architecturecomponents.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataBindingBinding
    private lateinit var dataBindingViewModel: DataBindingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Simple set Data
          //  binding.txtQuote.text = "EACH OF US HAS BUILT THIS CIVILIZATION"
         //  binding.txtAuthor.text = "Krishnamurti"


        // Set Data by Using Data Class
       /* val quoteObject = QuoteDataClass("EACH OF US HAS BUILT THIS CIVILIZATION", "Krishnamurti")
        binding.quote = quoteObject
        */


        // Set Data by using ViewModel and LiveData (One Way and Two Way)

        dataBindingViewModel = ViewModelProvider(this).get(DataBindingViewModel::class.java)

        /*dataBindingViewModel.quoteDataBinding.observe(this, Observer {
            binding.txtQuote.text = it
        })
        dataBindingViewModel.authorDataBinding.observe(this, Observer {
            binding.txtAuthor.text = it
        })*/
        /*
        binding.btnChange.setOnClickListener{
            dataBindingViewModel.changeQuote()
        }*/

        binding.dataViewModel = dataBindingViewModel
        binding.lifecycleOwner = this




    }
}