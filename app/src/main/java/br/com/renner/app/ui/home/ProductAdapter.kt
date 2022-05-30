package br.com.renner.app.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.renner.app.data.Product
import br.com.renner.app.databinding.ItemProductBinding
import com.bumptech.glide.Glide

class ProductAdapter(
    private val onClickListener: (product: Product) -> Unit = {}
) : ListAdapter<Product, ProductAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Product) {
            Glide.with(binding.root.context)
                .load(item.imgUrl)
                .into(binding.imgProduct)

            binding.txtProductName.text = item.name
            binding.txtProductPrice.text = "R$ ${item.price}"

            binding.root.setOnClickListener { onClickListener(item) }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem
        override fun areContentsTheSame(
            oldItem: Product,
            newItem: Product
        ) = oldItem.name == newItem.name
    }

}