package com.candybytes.taco.ui.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.candybytes.taco.R
import com.candybytes.taco.vo.Category

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private val items: ArrayList<Category> = ArrayList()

    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title)
        var id: TextView = view.findViewById(R.id.category_id)
        var amount: TextView = view.findViewById(R.id.amount_of_food_items)

        fun bind(category: Category) {
            title.text = category.name
            id.text = "#" + category.id.toString()
            amount.text = "000 food items"
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_category, viewGroup, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: CategoryViewHolder, position: Int) {
        viewHolder.title.text = items[position].name
        viewHolder.id.text = "#" + items[position].id.toString()
        viewHolder.amount.text = "000 food items"
    }

    fun updateCategories(categories: List<Category>?) {
        if (categories != null) {
            items.clear()
            items.addAll(categories)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}