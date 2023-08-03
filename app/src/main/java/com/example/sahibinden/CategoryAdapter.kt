package com.example.sahibinden

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.sahibinden.databinding.CategoriesListItemBinding

class CategoryAdapter(
    private val context: Context,
    private var categories: List<Category>,
    val onClick: (Category, position: Int) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CustomViewHolder>() {

    class CustomViewHolder(binding: CategoriesListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val ivCategoryIcon = binding.ivCategoryIcon
        val tvCategoryName = binding.tvCategoryName
        val tvCategoryText = binding.tvCategoryText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):CustomViewHolder {
        val view = CategoriesListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val categories = categories[position]

        holder.itemView.setOnClickListener {
            onClick(categories, position)
        }

        holder.ivCategoryIcon.load(categories.categoryPic)
        holder.tvCategoryName.text = categories.categoryName
        holder.tvCategoryText.text = categories.categoryText

    }
    fun updateList(filteredList:List<Category>){
        categories =filteredList
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}