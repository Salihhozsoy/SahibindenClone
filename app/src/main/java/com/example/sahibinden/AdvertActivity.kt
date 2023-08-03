package com.example.sahibinden

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sahibinden.databinding.ActivityAdvertBinding
class AdvertActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdvertBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdvertBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val category = intent.getParcelableExtra<Category>(MainActivity.CATEGORY)

        category?.let {
            binding.tvAdvertTitle.text =it.AdvertTitle
        }
        binding.ivBackArrow.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        binding.user =User(1,"salih","özsoy")
    }
}