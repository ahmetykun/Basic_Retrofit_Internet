package com.example.connecttotheinternet_proje.data.source.remote

import retrofit2.Call
import retrofit2.http.GET
import com.example.connecttotheinternet_proje.data.model.Product

//tüm claslarda erişimisağlar
interface ProductApiService {

    @GET("get_products.php")
    fun getProducts(): Call<List<Product>?>


//    @POST("search_products.php")
//    fun searchProducts():Call<List<ProductItem>>

}