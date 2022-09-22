package com.example.connecttotheinternet_proje.common

import com.example.connecttotheinternet_proje.common.Constants.BASE_URL
import com.example.connecttotheinternet_proje.data.source.remote.ProductApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiUtils {
    private var retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val productApiService: ProductApiService by lazy { retrofit.create(ProductApiService::class.java) }
}