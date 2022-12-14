package com.example.connecttotheinternet_proje.uı.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.connecttotheinternet_proje.R
import com.example.connecttotheinternet_proje.common.ApiUtils
import com.example.connecttotheinternet_proje.common.viewBinding
import com.example.connecttotheinternet_proje.data.model.Product
import com.example.connecttotheinternet_proje.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val productsAdapter by lazy { ProductsAdapter() }
    private val service = ApiUtils.productApiService

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productsAdapter.onProductClick = {
            val action = HomeFragmentDirections.actionHomeToDetail(it)
            findNavController().navigate(action)
        }

        service.getProducts().enqueue(object : Callback<List<Product>?> {

            override fun onResponse(//işlem başarılıysa listenin sonucu
                call: Call<List<Product>?>,
                response: Response<List<Product>?>
            ) {
                response.body()?.let {
                    productsAdapter.submitList(it)
                    binding.rvProducts.adapter = productsAdapter

                }
            }

            //internet ileilgili va ya başka sorunlar onFailure düşüyor.
            override fun onFailure(call: Call<List<Product>?>, t: Throwable) {
                Log.d("Failure", t.message.orEmpty())
            }

        })

    }

}