package br.com.renner.app.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.renner.app.data.Category
import br.com.renner.app.databinding.ItemCategoryBinding
import com.bumptech.glide.Glide

class CategoryAdapter(
    private val onClickListener: () -> Unit = {}
) : ListAdapter<Category, CategoryAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Category) {
            binding.txtCategory.text = item.name

            Glide.with(binding.root.context)
                .load(item.imgUrl)
                .into(binding.imgCategory)

            binding.root.setOnClickListener { onClickListener() }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category) = oldItem == newItem
        override fun areContentsTheSame(
            oldItem: Category,
            newItem: Category
        ) = oldItem.name == newItem.name
    }

}