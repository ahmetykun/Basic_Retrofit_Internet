package com.example.connecttotheinternet_proje.uı.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.connecttotheinternet_proje.data.model.Product
import com.example.connecttotheinternet_proje.databinding.ItemProductsBinding

class ProductsAdapter :
    ListAdapter<Product, ProductsAdapter.ProductViewHolder>(ProductDiffUtilCallback) {


    //Bunu kullanıcağım yerde Product yerleştiriceğim anlamına gelir.
    var onProductClick: (Product) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            ItemProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding, onProductClick)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
        holder.bind(currentList[position])

    class ProductViewHolder(
        private val binding: ItemProductsBinding, private val onProductClick: (Product) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {

            with(binding) {

                tvTitle.text = product.title
                tvPrice.text = "${product.price} ₺"
                Glide.with(binding.imgProducts).load(product.image).into(binding.imgProducts)

                root.setOnClickListener { onProductClick(product) }
            }
        }
    }
}

object ProductDiffUtilCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem
}
