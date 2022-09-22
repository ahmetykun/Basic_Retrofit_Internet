package com.example.connecttotheinternet_proje.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    //değişkenler raklıysa json la @SerializedName olarak belirmek gerekiyor.
    //  @SerializedName("description")
    val description: String?,

    //  @SerializedName("id")
    val id: String?,

    //  @SerializedName("image")
    val image: String?,

    //  @SerializedName("price")
    val price: Double?,

    //  @SerializedName("title")
    val title: String?,

    ) : Parcelable
