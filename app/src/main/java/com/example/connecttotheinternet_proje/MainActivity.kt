package com.example.connecttotheinternet_proje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.connecttotheinternet_proje.common.viewBinding
import com.example.connecttotheinternet_proje.databinding.ActivityMainBinding
import com.example.connecttotheinternet_proje.databinding.FragmentHomeBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding ( ActivityMainBinding::inflate )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}