package com.example.connecttotheinternet_proje.uı.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.connecttotheinternet_proje.R
import com.example.connecttotheinternet_proje.common.viewBinding
import com.example.connecttotheinternet_proje.databinding.FragmentDetailBinding
import com.example.connecttotheinternet_proje.databinding.FragmentHomeBinding


class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)

    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            //with kullanarak daha okunabilir hale getirildi.
            args.product.let {

                tvTitle.text = it.title
                tvPrice.text = "${it.price}"
                tvDescription.text = it.description
                Glide.with(imgProducts).load(it.image).into(imgProducts)
//                binding.tvTitle.text=it.title
//                binding.tvPrice.text="${it.price}"
//                binding.tvDescription.text=it.description
//                Glide.with(binding.imgProducts).load(it.image).into(binding.imgProducts)

            }
        }

    }


}