package com.example.architecturecomponents.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.architecturecomponents.R
import com.example.architecturecomponents.classes.PostDataClass
import com.example.architecturecomponents.databinding.ActivityDataBindingAdapterBinding

class DataBindingAdapterActivity : AppCompatActivity() {

   private lateinit var binding : ActivityDataBindingAdapterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_adapter)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val postObj = PostDataClass("Android Jetpack", "Last year, we launched Android Jetpack, a collection of software components designed to accelerate Android development and make writing high-quality apps easier. Jetpack was built with you in mind -- to take the hardest, most common developer problems on Android and make your lives easier.",
            "https://miro.medium.com/v2/resize:fit:1400/1*lDGK7qz9h3xQP_IUoZxGaQ.png")

        binding.post = postObj
    }

}